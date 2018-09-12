package algorithm.leetcode;

//求众数
//        给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
//        你可以假设数组是非空的，并且给定的数组总是存在众数。
//
//        示例 1:
//
//        输入: [3,2,3]
//        输出: 3
//        示例 2:
//
//        输入: [2,2,1,1,1,2,2]
//        输出: 2

//思路：摩尔选举算法
//        每次都找出一对不同的元素，从数组中删掉，直到数组为空或只有一种元素。
//        不难证明，如果存在元素e出现频率超过半数，那么数组中最后剩下的就只有e。

public class No169 {
    public int majorityElement(int[] nums) {
        int res=0,count=0;
        for(int num:nums){
            if(count==0){
                res=num;
                count=1;
            }else if(num==res){
                count++;
            }else{
                count--;
            }
        }
        return res;
    }
}
