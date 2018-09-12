package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No130 {
    public void solve(char[][] board) {
        int m=board.length;
        if(m==0) return;
        int n=board[0].length;
        if(n==0) return ;
        List<Integer> xList=new ArrayList<>();
        List<Integer> yList=new ArrayList<>();
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                xList.add(i);
                yList.add(0);
            }
            if(board[i][n-1]=='O'){
                xList.add(i);
                yList.add(n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                xList.add(0);
                yList.add(i);
            }
            if(board[m-1][i]=='O'){
                xList.add(m-1);
                yList.add(i);
            }
        }
        while(!xList.isEmpty()){
            int x=xList.remove(0);
            int y=yList.remove(0);
            board[x][y]='y';
            if(x>1 && board[x-1][y]=='O'){
                xList.add(x-1);
                yList.add(y);
            }
            if(x<m-1 && board[x+1][y]=='O'){
                xList.add(x+1);
                yList.add(y);
            }
            if(y>1 && board[x][y-1]=='O'){
                xList.add(x);
                yList.add(y-1);
            }
            if(y<n-1 && board[x][y+1]=='O'){
                xList.add(x);
                yList.add(y+1);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='y'){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
    }
}
