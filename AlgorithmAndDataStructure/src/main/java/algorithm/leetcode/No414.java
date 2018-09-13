package algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class No414 {
    public int thirdMax(int[] nums) {
        int max=Integer.MIN_VALUE,sec=Integer.MIN_VALUE,thi=Integer.MIN_VALUE;
        boolean flag=false;
        for(int i:nums){
            if(i>max){
                max=i;
            }
        }
        for(int i:nums){
            if(i>sec && i!=max){
                sec=i;
            }
        }
        for(int i:nums){
            if(i>=thi && i!=max && i!=sec){
                thi=i;
                flag=true;
            }
        }
        return flag? thi:max;
    }

    @Test
    public void test01(){
        System.out.println(thirdMax(new int[]{3,2,1}));
    }
}
