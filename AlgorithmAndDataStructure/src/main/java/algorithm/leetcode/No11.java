package algorithm.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 注意：你不能倾斜容器，n 至少是2。
 * Created by WYS on 2018/6/2.
 */
public class No11 {
    //O（n*n）超时
    public int maxArea1(int[] height) {
        int len = height.length;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                sum = Math.min(height[i], height[j]) * (j - i);
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxVol=0;
        while(i<j){
            int tmp=Math.min(height[i],height[j])*(j-i);
            maxVol=tmp>maxVol?tmp:maxVol;
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxVol;
    }
}
