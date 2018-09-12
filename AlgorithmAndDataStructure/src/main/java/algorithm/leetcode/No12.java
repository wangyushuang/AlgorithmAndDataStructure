package algorithm.leetcode;

import org.junit.Test;

/**
 * 整数转罗马数字
 * Created by WYS on 2018/6/3.
 */
public class No12 {
    @Test
    public void test() {
        System.out.println(intToRoman(1994));
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[] chars = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] ints = {1000, 500, 100, 50, 10, 5, 1};
        int i = 0;
        boolean flag = false;
        while (i < chars.length) {
            int j = flag ? 1 : 2;
            while (num >= ints[i]) {
                sb.append(chars[i]);
                num -= ints[i];
            }
            if (i <chars.length-1 && num >= (ints[i] - ints[i + j])) {
                sb.append(chars[i + j]);
                sb.append(chars[i]);
                num -= (ints[i] - ints[i + j]);
            }
            flag = !flag;
            i++;
        }
        return sb.toString();
    }
}
