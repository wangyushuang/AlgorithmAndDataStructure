package exam;//合唱团
//题目描述
//        有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
//        输入描述:
//        每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
//        输出描述:
//        输出一行表示最大的乘积。
//        示例1
//        输入
//        复制
//        3
//        7 4 7
//        2 50
//        输出
//        复制
//        49

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ability = new int[n];
        for (int i = 0; i < n; i++) {
            ability[i] = in.nextInt();
        }
        int k = in.nextInt();
        int d = in.nextInt();

//        System.out.println(solve01(ability, k, d));  //暴力解法
        System.out.println(solve02(ability, n, k, d));  //暴力解法

    }

    //动态规划DP
    public static Long solve02(int[] ability, int n, int k, int d) {
        long [][] maxVal=new long[n][k];
        long [][] minVal=new long[n][k];
        for(int i=0;i<n;i++){
            maxVal[i][0]=ability[i];
            minVal[i][0]=ability[i];
        }
        for(int i=1;i<n;i++){
            int tmp=Math.min(i,k-1);
            for(int j=1;j<=tmp;j++){
                int tmp1=Math.max(i-d,j-1);
                for(int p=i-1;p>=tmp1;p--){
                    long max=maxVal[p][j-1]*ability[i];
                    long min=minVal[p][j-1]*ability[i];
                    maxVal[i][j]=Math.max(maxVal[i][j],Math.max(max,min));
                    minVal[i][j]=Math.min(minVal[i][j],Math.min(max,min));
                }
            }
        }
        long max=Long.MIN_VALUE;
        for(int i=k-1;i<n;i++){
            if(maxVal[i][k-1]>max){
                max=maxVal[i][k-1];
            }
        }
        return max;
    }


    //暴力解法
    public static Long solve01(int[] ability, int k, int d) {
        List<Long> list = new ArrayList<>();
        k--;
        for (int i = 0; i < ability.length; i++) {
            search01(ability, k, d, ability[i], i, list);
        }
        long max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max)
                max = list.get(i);
        }
        return max;
    }

    private static void search01(int[] ability, int k, int d, long prod, int index, List<Long> list) {
        if (k == 0) {
            list.add(prod);
            return;
        }
        for (int i = 1; i <= d && (index + i < ability.length); i++) {
            search01(ability, k - 1, d, prod * ability[index + i], index + i, list);
        }
    }
}
