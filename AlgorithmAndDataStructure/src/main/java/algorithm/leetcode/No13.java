package algorithm.leetcode;

import org.junit.Test;

/**
 * 罗马数字转整数
 * Created by WYS on 2018/6/3.
 */
public class No13 {
    char aChar;

    @Test
    public void test(){
        System.out.println(aChar);
    }
    public int romanToInt(String s) {
        int res = 0;
        char[] chars = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] ints = {1000, 500, 100, 50, 10, 5, 1};
        char[] origin = s.toCharArray();
        int i = 0, j = 0;
        boolean flag = false;
        while (i < chars.length) {
            int k = flag ? 1 : 2;
            while (j<s.length() && chars[i] == origin[j]) {
                res += ints[i];
                j++;
            }
            if (j<s.length()-1 && i<chars.length-1 && origin[j] == chars[i+ k] && origin[j + 1] == chars[i]) {
                res += ints[i] - ints[i + k];
                j += 2;
            }
            i++;
            flag = !flag;
        }
        return res;
    }
}
