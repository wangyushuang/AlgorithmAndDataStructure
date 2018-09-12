package algorithm.leetcode;

import org.junit.Test;

import java.io.CharArrayReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * <p>
 * Created by WYS on 2018/6/1.
 */
public class No5 {
    @Test
    public void test() {
        String s = "abcba";
        System.out.println(longestPalindrome(s));
    }

    //最长公共子串法
    public String longestPalindrome1(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        String s1 = sb.toString();
        int end = 0;
        int longest = 0;
        int[][] A = new int[len + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            A[0][i] = 0;
        }
        for (int i = 0; i <= len; i++) {
            A[i][i] = 0;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == s1.charAt(j)) {
                    int tmp = A[i][j] + 1;
                    A[i + 1][j + 1] = tmp;
                    //一定要判断：原字符串回文的开始字符位置+翻转序列中回文结束位置==len-1
                    if (tmp > longest && (i + j + 1 - tmp) == len - 1) {
                        longest = A[i + 1][j + 1];
                        end = i;
                    }
                } else {
                    A[i + 1][j + 1] = 0;
                }
            }
        }
        return s.substring(end - longest + 1, end + 1);
    }

    //暴力法 超时
    public String longestPalindrome2(String s) {
        int len = s.length();
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 1; j < len; j++) {
                //判断s[i]-s[j]是否为回文
                int p1 = i, p2 = j;
                while (p1 < p2) {
                    if (s.charAt(p1) != s.charAt(p2)) {
                        break;
                    }
                    p1++;
                    p2--;
                }
                if (p1 >= p2) {
                    int tmp = j - i + 1;
                    if (tmp > maxLen) {
                        start = i;
                        maxLen = tmp;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    //动态规划
    public String longestPalindrome3(String s) {
        int len = s.length();
        int[][] A = new int[len][len];
        int maxLen = 1;
        int end = 0;
        for (int i = 0; i < len; i++) {
            A[i][i] = 1;
        }
        for (int i = 0; i < len - 1; i++) {
            A[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)) ? 2 : 0;
            if (maxLen != 2 && A[i][i + 1] == 2) {
                maxLen = 2;
                end = i + 1;
            }
        }
        for (int j = 2; j < len; j++) {
            for (int i = 0; i < j - 1; i++) {
                if (s.charAt(j) == s.charAt(i) && A[i + 1][j - 1] > 0) {
                    A[i][j] = A[i + 1][j - 1] + 2;
                    if (A[i][j] > maxLen) {
                        maxLen = A[i][j];
                        end = j;
                    }
                } else {
                    A[i][j] = 0;
                }
            }
        }
        return s.substring(end - maxLen + 1, end + 1);
    }

    //高效算法
    public String longestPalindrome(String s) {
        int[] index = new int[]{0, 0};
        char[] chars = s.toCharArray();
        int len=chars.length;
        for(int i=0;i<len;i++){
            findPalindrome(chars,len,index,i);
        }
        return s.substring(index[0],index[1]+1);
    }

    //[low,high]为回文
    private void findPalindrome(char[] chars, int len, int[] index, int n) {
        int high = n;
        int low = n;
        while (high < len-1 && chars[high+1] == chars[n]) {
            high++;
        }
        while (low >0 && high < len-1 && chars[low-1] == chars[high+1]) {
            low--;
            high++;
        }
        if ((high - low) > (index[1] - index[0])) {
            index[0] = low;
            index[1] = high;
        }

    }
}
