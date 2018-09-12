package algorithm.leetcode;

/**
 * 实现 atoi，将字符串转为整数。
 * <p>
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * <p>
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * <p>
 * 若函数不能执行有效的转换，返回 0。
 * Created by WYS on 2018/6/2.
 */
public class No8 {
    public int myAtoi(String str) {
        int i = 0;
        int len = str.length();
        boolean isNegtive = false;
        while (i < len && str.charAt(i) == ' ')
            i++;
        if (i >= len)
            return 0;
        if (str.charAt(i) == '-') {
            isNegtive = true;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        if (i >= len)
            return 0;
        long result = 0;
        while (i < len) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9')
                result = result * 10 + str.charAt(i) - '0';
            else
                break;
            if(result>Integer.MAX_VALUE)
                break;
            i++;
        }
        result = isNegtive ? -result : result;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
