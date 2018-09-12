package algorithm.leetcode;

public class No79 {
    boolean result=false;
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        if(m==0) return false;
        int n=board[0].length;
        if(n==0) return false;

        char[] wch=word.toCharArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                search(board,wch,0,i,j,new boolean[m][n]);
                if(result)
                    return result;
            }
        }
        return result;
    }

    public boolean search(char[][] board,char[] wch,int index,int i,int j,boolean[][] visited){
        if(index==wch.length){
            result=true;
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=wch[index] || visited[i][j])
            return false;
        visited[i][j]=true;
        boolean flag=
        search(board,wch,index+1,i-1,j,visited) ||
        search(board,wch,index+1,i+1,j,visited) ||
        search(board,wch,index+1,i,j-1,visited) ||
        search(board,wch,index+1,i,j+1,visited);
        visited[i][j]=false;
        return flag;
    }
}
