package algorithm.leetcode;

//任务调度器

import java.util.Arrays;

public class No621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        for (char task : tasks) {
            count[task-'A']++;
        }
        int maxCount=0;
        for(int c:count){
            if(c>maxCount)
                maxCount=c;
        }
        int tmp=0;
        for(int i=25;i>=0;i--){
            if(count[i]==maxCount){
                tmp++;
            }
        }
        return Math.max(tasks.length,(maxCount-1)*(n+1)+tmp);
    }
}
