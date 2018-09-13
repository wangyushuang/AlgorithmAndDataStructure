package algorithm.leetcode;

import org.junit.Test;

import java.util.*;

public class No310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)
            return Collections.singletonList(0);
        List<Set<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new HashSet());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(adj.get(i).size()==1){
                leaves.add(i);
            }
        }
        while(n>2){
            n-=leaves.size();
            List<Integer> newLeaves=new ArrayList<>();
            for(int leave:leaves){
                int t=adj.get(leave).iterator().next();
                adj.get(t).remove(leave);
                if(adj.get(t).size()==1) newLeaves.add(t);

            }
            leaves=newLeaves;
        }
        return leaves;
    }

    @Test
    public void test1(){
        Set set=new HashSet(Arrays.asList(new int[]{1,2}));
//        findMinHeightTrees()
    }
}
