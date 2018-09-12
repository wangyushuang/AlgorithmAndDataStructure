package algorithm.leetcode;

import org.junit.Test;

/**
 * Created by WYS on 2018/6/2.
 */
public class No9 {
    @Test
    public void test() {
        int a = 1221;
        int len = Integer.toString(a).length();
        System.out.println(isPalindrome(a));
    }

    public boolean isPalindrome1(int x) {
        if (x < 0)
            return false;
        int len = Integer.toString(x).length();
        while (len > 0) {
            int high = (int) (x / Math.pow(10, len - 1));
            int low = x % 10;
            if (high == low) {
                x = x - (int) (high * Math.pow(10, len - 1));
                x = x / 10;
                len = len - 2;
            } else {
                return false;
            }
        }
        return true;
    }

    //方法二：效率高
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        long reverse = 0;
        long origin = x;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        if (reverse == origin)
            return true;
        return false;
    }
}
