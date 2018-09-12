package exam;

import java.util.LinkedList;
import java.util.Scanner;

//地牢逃脱
//给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，
//        牛牛从 (x0 , y0 ) 位置出发，遍历这个地牢，和一般的游戏所不同的是，
//        他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边界，
//        也不能到达障碍上。地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，
//        他需要多少步才可以离开这个地牢。

//链接：https://www.nowcoder.com/questionTerminal/0385945b7d834a99bc0010e67f892e38
//        来源：牛客网
//
//        输入描述:
//        每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 50），
// 表示地牢的长和宽。接下来的 n 行，每行 m 个字符，描述地牢，地牢将至少包含两个 '.'。
// 接下来的一行，包含两个整数 x0, y0，表示牛牛的出发位置（0 <= x0 < n, 0 <= y0 < m，左上角的坐标为 （0, 0），
// 出发位置一定是 '.'）。之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数，
// 接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50）

//思路：BFS
public class No9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            System.arraycopy(s.toCharArray(), 0, map[i], 0, m);
        }
        int x0 = in.nextInt();
        int y0 = in.nextInt();
        int k = in.nextInt();
        int[][] step = new int[k][2];
        for (int i = 0; i < k; i++) {
            step[i][0]=in.nextInt();
            step[i][1]=in.nextInt();
        }
        int res=solve01(n,m,map,x0,y0,k,step);
        System.out.println(res-1);

    }

    public static int solve01(int n, int m, char[][] map, int x0, int y0, int k, int[][] step) {
        LinkedList<Integer> xque=new LinkedList<>();
        LinkedList<Integer> yque=new LinkedList<>();
        xque.add(x0);
        yque.add(y0);
        int[][] visited=new int[n][m];
        visited[x0][y0]=1;
        while(!xque.isEmpty() && !yque.isEmpty()){
            x0=xque.remove();
            y0=yque.remove();
//            visited[x0][y0]=true;
            for(int i=0;i<k;i++){
                int xTmp=x0+step[i][0];
                int yTmp=y0+step[i][1];
                if(xTmp>=0 && xTmp<n && yTmp>=0 && yTmp<m && visited[xTmp][yTmp]==0 && map[xTmp][yTmp]=='.'){
                    visited[xTmp][yTmp]=visited[x0][y0]+1;
                    xque.add(xTmp);
                    yque.add(yTmp);
                }
            }
        }
        int max=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]>max)
                    max=visited[i][j];
                if(map[i][j]=='.' && visited[i][j]==0)
                    return 0;
            }
        }

        return max;
    }

}
