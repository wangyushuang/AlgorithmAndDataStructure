package exam;//校招全国统一模拟笔试技术类编程题汇总
//一般的括号匹配问题是这样的：
//
//        给出一个字符串，判断这个括号匹配是不是合法的括号匹配。
//
//        如"((" 和 "())"都不是合法的括号匹配，但是"()()()"，"(()())()"等就是合法的括号匹配。
//
//        这个问题解决起来非常简单，相信大家都知道怎么解决。
//
//        现在给出一个加强版的括号匹配问题： 给出n个由括号 '(' 和 ‘)’ 组成的字符串，请计算出这些字符串中有多少对字符串满足si + sj是合法的括号匹配。如果si + sj和sj + si都是合法的括号匹配(i ≠ j)，那么这两种搭配都需要计入答案；如果对于si，si + si是合法的括号匹配，那么也需要计入答案。
//
//
//        输入描述:
//        第一行是一个整数n，表示字符串的个数；
//
//        接下来n行是n个非空字符串，全部由'('和')'组成。
//
//        1 <= n <= 3 * 105，字符串的长度之和不超过3 * 105。
//
//
//
//        输出描述:
//        一个整数，表示满足条件的字符串对的数量。
//
//        输入例子1:
//        3
//        ()
//        (
//        )
//
//        输出例子1:
//        2

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 暴力破解的方法时间复杂度为O(n*n),不满足要求，需要降到O(n)
 * 思路：
 *      1.去除字符串中已经配对好的括号
 *      2.判断字符串是否为双端开口情况
 *      3.将字符串转化为包含字符串信息的数字
 *      4.将代表字符串的数字存入Map中，值为字符串出现次数
 *      5.根据“和为0的两个字符串配对成功”，计算结果
 */
public class No6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //字符串个数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = in.next();
            s = trim(s);
            //判断是否左右都开口，比如:")("
            if (s.length() > 1 && s.charAt(0) != s.charAt(s.length() - 1))
                continue;
            //转换为数字,存入Map中
            int cal = convToNum(s);
            if (map.containsKey(cal)) {
                map.replace(cal, map.get(cal) + 1);
            } else {
                map.put(cal, 1);
            }
        }
        int res = 0;
        for (int n : map.keySet()) {
            if (n >= 0 && map.containsKey(-n)) {
                res += map.get(n) * map.get(-n);
            }
        }
        System.out.println(res);
    }

    /**
     * 修剪字符串，将配对的括号去除
     *
     * @param s
     * @return
     */
    public static String trim(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == ')') {
                int len = sb.length();
                if (len > 0 && sb.charAt(len - 1) == '(') { //配对成功
                    sb.deleteCharAt(len - 1);
                    continue;
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * 将字符串转化为数字
     * trim()处理之后并判断是否两端开口之后，s有三种情况：
     * 1.空字符串，表示字符串本身为合法匹配 返回0
     * 2.全为左括号 返回字符串长度的相反数
     * 3.全为右括号 返回字符串长度
     *
     * @param s
     * @return
     */
    public static int convToNum(String s) {
        if ("".equals(s))
            return 0;
        int res = s.length();
        if (s.charAt(0) == '(')
            res *= -1;
        return res;
    }
}