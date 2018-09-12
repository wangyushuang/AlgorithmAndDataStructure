package algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by WYS on 2018/6/1.
 * 3.给定一个字符串，找出不含有重复字符的最长子串的长度。
 */
public class No3 {
    @Test
    public void test() {
        String s1 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s1));
        int[] a = {1, 2, 3};
        int[] b = new int[5];
        System.arraycopy(a,0,b,2,2);
        System.out.println(Arrays.toString(b));
        List<Integer> list=new ArrayList<>();
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        List<Character> list = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (list.contains(ch)) {
                int curLen = list.size();
                if (curLen > ans)
                    ans = curLen;
                int pos = list.indexOf(ch);
                for (int j = 0; j <= pos; j++) {
                    list.remove(0);
                }
            }
            list.add(ch);
        }
        if (list.size() > ans)
            ans = list.size();
        return ans;
    }

    //优化的滑动窗口
    public int lengthOfLongestSubstring1(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int pre = 0;//窗口起始点
        int ans = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                pre = Math.max(pre, map.get(ch));
            }
            ans = Math.max(ans, i - pre + 1);
            map.put(ch, i + 1);
        }
        return ans;
    }
}
