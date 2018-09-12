package algorithm.leetcode;

import org.junit.Test;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * Created by WYS on 2018/6/2.
 */
public class No10 {
    @Test
    public void test() {
        String s = "aabgdfd";
        String p = "a.*";
        System.out.println(isMatch(s, p));
        boolean [] b=new boolean[2];
        System.out.println(b[0]+" "+b[1]);
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        char[] schars = s.toCharArray();
        char[] pchars = p.toCharArray();
        return isMatchCore(schars, pchars, sLen - 1, pLen - 1);
    }

    private boolean isMatchCore(char[] schars, char[] pchars, int i, int j) {
        if (j < 0)
            return i < 0;
        if (pchars[j] == '*') {
            if (j == 0)
                return false;
            if (i >= 0 && (pchars[j - 1] == schars[i] || pchars[j - 1] == '.')) {
                char ch = schars[i];
                while (i >= 0 && schars[i] == ch) {
                    if (isMatchCore(schars, pchars, i--, j - 2)) {
                        return true;
                    }
                }
                if (pchars[j - 1] == '.')
                    return isMatchCore(schars, pchars, i, j - 2) || isMatchCore(schars, pchars, i - 1, j);
                else
                    return isMatchCore(schars, pchars, i, j - 2);
            } else {
                return isMatchCore(schars, pchars, i, j - 2);
            }
        } else {
            if (i >= 0 && (schars[i] == pchars[j] || pchars[j] == '.')) {
                return isMatchCore(schars, pchars, i - 1, j - 1);
            } else {
                return false;
            }
        }
    }

    //最短用时范例
    public boolean isMatch1(String s, String p) {
        boolean[] match = new boolean[s.length() + 1];
        match[s.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                //如果是星号，从后往前匹配
                for (int j = s.length() - 1; j >= 0; j--) {
                    match[j] = match[j] || (match[j + 1] && (p.charAt(i - 1) == '.'
                            || (p.charAt(i - 1) == s.charAt(j))));
                }
                //记得把i多减1，因为星号是和其前面的字符匹配使用
                i--;

            } else {
                //如果不是星号，从前往后匹配
                for (int j = 0; j < s.length(); j++) {
                    match[j] = match[j + 1] && (p.charAt(i) == '.' || (p.charAt(i) == s.charAt(j)));
                }
                //只要试过了pattern中最后一个字符，就要把match【s。length（）】置为false
                match[s.length()] = false;
            }
        }
        return match[0];
    }
}
