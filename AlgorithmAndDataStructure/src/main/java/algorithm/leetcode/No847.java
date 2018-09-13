package algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//BFS

public class No847 {
    class Node{
        int index;
        int status;
        int steps;

        public Node(int index, int status, int steps) {
            this.index = index;
            this.status = status;
            this.steps = steps;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int N=graph.length;
        Queue<Node> queue=new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(new Node(i,1<<i,0));
        }
        int flag=(1<<N)-1;//N-1个1
        boolean[][] visited=new boolean[N][1<<N];
        while(!queue.isEmpty()){
            Node node=queue.poll();
            if(node.status==flag){
                return node.steps;
            }
            for(int i:graph[node.index]){
                int newStatus= node.status | (1<<i);
                if(!visited[i][newStatus]){
                    visited[i][newStatus]=true;
                    queue.offer(new Node(i,newStatus,node.steps+1));
                }
            }
        }
        return -1;
    }
}
