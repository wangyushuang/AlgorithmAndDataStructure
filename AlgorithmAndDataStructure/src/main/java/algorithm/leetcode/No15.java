package algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * Created by WYS on 2018/6/3.
 */

/**
 * 1.排序，复杂度O(nlgn)
 * 2.求两数之和，外层嵌套循环，复杂度O(n^2)
 * 3.整体时间复杂度O（n^2）
 */
public class No15 {
    @Test
    public void test() {
        int[] a = {-1,0,1,2,-1,-4};
        System.out.println(threeSum1(a));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        quickSort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i!=0 && nums[i]==nums[i-1]){//防止重复
                continue;
            }
            int p = i + 1, q = nums.length - 1;
            while (p < q) {
                int sum = nums[p] + nums[q] + nums[i];
                if (sum == 0) {
                    List list = Arrays.asList(nums[i], nums[p], nums[q]);
                    result.add(list);
                    p++;
                    q--;
                    //防止重复
                    while (p < q && nums[p - 1] == nums[p]) {
                        p++;
                    }
                    while (p < q && nums[q + 1] == nums[q]) {
                        q--;
                    }
                } else if (sum < 0) {
                    p++;
                } else {
                    q--;
                }

            }
        }
        return result;
    }

    public void quickSort(int[] num) {
        quickSortCore(num, 0, num.length - 1);
    }

    private void quickSortCore(int[] num, int left, int right) {
        if (left >= right)
            return;
        int key = num[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && num[j] >= key)
                j--;
            if (i < j)
                num[i] = num[j];
            while (i < j && num[i] <= key)
                i++;
            if (i < j)
                num[j] = num[i];
        }
        num[i] = key;
        quickSortCore(num, left, i - 1);
        quickSortCore(num, i + 1, right);
    }


    //方法二
    public List<List<Integer>> threeSum1(int[] nums){
        if(nums.length<3)
            return Collections.emptyList();
        List<List<Integer>> res=new ArrayList<>();
        int vmax=Integer.MIN_VALUE;
        int vmin=Integer.MAX_VALUE;
        int nNeg=0;
        int nPos=0;
        for(int num:nums){
            if(num>vmax)
                vmax=num;
            if(num<vmin){
                vmin=num;
            }
        }
        if(!((vmin>=0) ^ (vmax>0))){
            return res;
        }
        if(vmax>-2*vmin){
            vmax=-2*vmin;
        }
        if(vmin<-2*vmax){
            vmin=-2*vmax;
        }
        int[] map=new int[vmax-vmin+1];
        for(int num:nums){
            if(num<=vmax && num>=vmin){
                map[num-vmin]++;
            }
        }
        for(int i=0;i<-vmin;i++){
            if(map[i]!=0)
                nNeg++;
        }
        for(int i=-vmin+1;i<=vmax-vmin;i++){
            if(map[i]!=0)
                nPos++;
        }
        if(map[-vmin]>2){
            res.add(Arrays.asList(0,0,0));
        }
        int[] neg=new int[nNeg];
        int[] pos=new int[nPos];
        int in=0;
        int ip=0;
        for(int i=0;i<-vmin;i++){
            if(map[i]!=0){
                neg[in++]=i+vmin;
            }
        }
        for(int i=-vmin+1;i<=vmax-vmin;i++){
            if(map[i]!=0){
                pos[ip++]=i+vmin;
            }
        }
        Arrays.sort(neg);
        Arrays.sort(pos);
        for(int i=nNeg-1;i>=0;i--){
            int nv=neg[i];
//            int pMin=neg[i]>>>1;
            for(int j=0;j<nPos;j++){
                int pv=pos[j];
                int cv=-pv-nv;
                int index=cv-vmin;
                if(cv>nv && cv<pv && map[index]>0){
                    res.add(Arrays.asList(nv,cv,pv));
                }
                if(cv==nv && map[index]>=2){
                    res.add(Arrays.asList(nv,nv,pv));
                }
                if(cv==pv && map[index]>=2){
                    res.add(Arrays.asList(nv,pv,pv));
                }
            }
        }
        return res;
    }
}
