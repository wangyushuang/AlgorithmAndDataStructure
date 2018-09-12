package exam;

import java.util.Scanner;

public class No10 {
    static int n;
    static int m;
    static int[][] nums;
    static int[][] sum;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        nums = new int[n + 1][m + 1];
        sum = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            char[] chars = in.next().toCharArray();
            for (int j = 0; j < m; j++) {
                nums[i + 1][j + 1] = chars[j] - '0';
                sum[i + 1][j + 1] = nums[i + 1][j + 1] + sum[i + 1][j] + sum[i][j + 1] - sum[i][j];
            }
        }
        int result = 0;
        int l = 0, r = sum[n][m];
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (judge(mid)) {
                l = mid + 1;
                result = mid;
            } else {
                r = mid - 1;
            }
        }
//        System.out.println(judge(1));
        System.out.println(result);
    }

    public static boolean judge(int mid) {
        for (int i = 1; i <= m - 3; i++) {
            for (int j = i + 1; j <= m - 2; j++) {
                for (int k = j + 1; k <= m-1; k++) {
                    int prei = 0, count = 0;
                    for (int h = 1; h <= n; h++) {
                        int cube1 = getArea(prei, 0, h, i);
                        int cube2 = getArea(prei, i, h, j);
                        int cube3 = getArea(prei, j, h, k);
                        int cube4 = getArea(prei, k, h, m);
                        if (cube1 >= mid && cube2 >= mid && cube3 >= mid && cube4 >= mid) {
                            count++;
                            prei = h;
                        }
                    }
                    if (count >= 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int getArea(int startX, int startY, int endX, int endY) {
        return sum[endX][endY] - sum[startX][endY] - sum[endX][startY] + sum[startX][startY];
    }
}
