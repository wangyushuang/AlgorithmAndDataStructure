package exam;//网易游戏
//小明是幼儿园的一名老师。某天幼儿园园长给小朋友们每人发一颗糖果，小朋友们拿到后发现有一些同学拿到的糖果颜色和自己相同，有一些同学糖果颜色和自己不同。
//        假定每个小朋友只知道有多少同学和自己拿到了相同颜色的糖果。
//        上课后，有一部分小朋友兴奋的把这一结果告诉小明老师，并让小明老师猜一猜，最少有多少同学拿到了糖果。
//        例如有三个小朋友告诉小明老师这一结果如下：
//        其中第一个小朋友发现有1人和自己糖果颜色一样，第二个小朋友也发现有1人和自己糖果颜色一样，第三个小朋友发现有3人和自己糖果颜色一样。
//        第一二个小朋友可互相认为对方和自己颜色相同，比如红色；
//        第三个小朋友不可能再为红色（否则第一二个小朋友会发现有2人和自己糖果颜色相同），假设他拿到的为蓝色糖果，那么至少还有另外3位同学拿到蓝色的糖果，最终至少有6位小朋友拿到了糖果。
//        现在请你帮助小明老师解答下这个谜题。
//
//        输入描述:
//        假定部分小朋友的回答用空格间隔，如 1 1 3
//
//
//        输出描述:
//        直接打印最少有多少位小朋友拿到糖果
//        如 6
//
//        输入例子1:
//        1 1 3
//
//        输出例子1:
//        6

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        test_02();
    }

    //时间复杂度O(nlgn)
    public static void test_01() {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        int[] same = new int[strs.length];
        int i = 0;
        for (String str : strs) {
            same[i++] = Integer.parseInt(str);
        }
        Arrays.sort(same);
        int min = 0;
        int p = 0, q = 1;
        while (q < same.length) {
            if (same[p] != same[q] || (q - p) > same[p]) {
                min += same[p] + 1;
                p = q;
            }
            q++;
        }
        min += same[p] + 1;
        System.out.println(min);
    }

    //时间复杂度O(n)
    public static void test_02() {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (String str : strs) {
            int num = Integer.parseInt(str);
            if (map.containsKey(num)) {
                map.replace(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int key : map.keySet()) {
            int val = map.get(key);
            result += val % (key + 1) == 0 ? val : (val + key + 1 - val % (key + 1));
        }
        System.out.println(result);
    }
}
