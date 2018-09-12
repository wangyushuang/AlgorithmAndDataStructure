package algorithm.leetcode;

public class No200 {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        if(m==0) return 0;
        int n=grid[0].length;
        if(n==0) return 0;
        boolean[][] visited=new boolean[m][n];
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    res++;
                    search(grid,visited,i,j);
                }
            }
        }
        return res;
    }
    public void search(char[][] grid,boolean[][] visited,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j]){
            return;
        }
        visited[i][j]=true;
        if(i>=1 && grid[i-1][j]=='1') search(grid,visited,i-1,j);
        if(i<grid.length-1 && grid[i+1][j]=='1') search(grid,visited,i+1,j);
        if(j>0 && grid[i][j-1]=='1') search(grid,visited,i,j-1);
        if(j<grid[0].length-1 && grid[i][j+1]=='1') search(grid,visited,i,j+1);
    }
}
