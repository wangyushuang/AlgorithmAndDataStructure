package exam;

import java.util.Scanner;

//网易游戏
//[编程题] 字符迷阵
//        字符迷阵是一种经典的智力游戏。玩家需要在给定的矩形的字符迷阵中寻找特定的单词。
//        在这题的规则中，单词是如下规定的：
//        1. 在字符迷阵中选取一个字符作为单词的开头；
//        2. 选取右方、下方、或右下45度方向作为单词的延伸方向；
//        3. 以开头的字符，以选定的延伸方向，把连续得到的若干字符拼接在一起，则称为一个单词。
public class No5 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int i=0;i<T;i++){
            int m=in.nextInt();
            int n=in.nextInt();
            char[][] table=new char[m][n];
            for(int j=0;j<m;j++){
                String str=in.next();
                table[j]=str.toCharArray();
            }
            char[] word=in.next().toCharArray();
            System.out.println(search(table,word));
        }
    }
    public static int search(char[][] table,char[] word){
        int result=0;
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[0].length;j++){
                if(word.length+i<=table.length && search_core(table,word,i,j,0,0))
                    result+=1;
                if(word.length+j<=table[0].length && search_core(table,word,i,j,0,1))
                    result+=1;
                if(word.length+i<=table.length && word.length+j<=table[0].length &&
                        search_core(table,word,i,j,0,2))
                    result+=1;
            }
        }
        return result;
    }
    public static boolean search_core(char[][] table,char[] word,int i,int j,int k,int flag){
        if(k==word.length)
            return true;
        if(table[i][j]!=word[k])
            return false;
        if(flag==0){
            return search_core(table,word,i+1,j,k+1,0);
        }else if(flag==1){
            return search_core(table,word,i,j+1,k+1,1);
        }else if(flag==2){
            return search_core(table,word,i+1,j+1,k+1,2);
        }
        return false;
    }
}
