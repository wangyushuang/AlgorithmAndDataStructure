package algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * <p>
 * 实现一个将字符串进行指定行数变换的函数:
 * <p>
 * string convert(string s, int numRows);
 * Created by WYS on 2018/6/2.
 */
public class No6 {
    @Test
    public void test() {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }

    public String convert(String s, int numRows) {
        if(s==null || s.equals("") || numRows==1)
            return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        char[] chars=s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int len = s.length();
        boolean flag = false;
        int j = 0;
        for (int i = 0; i < len; i++) {
            char ch = chars[i];
            if (j == numRows - 1)
                flag = true;
            if (j == 0)
                flag = false;
            if (!flag) {
                rows[j++].append(ch);
            } else {
                rows[j--].append(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(rows[i]);
        }
        return result.toString();
    }
}
