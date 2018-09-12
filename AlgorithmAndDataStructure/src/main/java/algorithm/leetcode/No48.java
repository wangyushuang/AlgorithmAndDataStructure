package algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 */
public class No48 {
    @Test
    public void test(){
        int[][] a ={{1,2,3},{4,5,6},{7,8,9}};
        rotate(a);
        for(int[] b:a)
            System.out.println(Arrays.toString(b));
        String s1="dsf";
        String s2="dsf";
        System.out.println(s1.indexOf(s2));

    }
    public void rotate(int[][] matrix) {
        int len=matrix.length;
        int mid=len>>1;
        for(int i=0;i<mid;i++){
            for(int j=i;j<len-1-i;j++){
                int tmp1=matrix[i][j];
                matrix[i][j]=matrix[len-1-j][i];
                matrix[len-1-j][i]=matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j]=matrix[j][len-1-i];
                matrix[j][len-1-i]=tmp1;
            }
        }
    }
}
