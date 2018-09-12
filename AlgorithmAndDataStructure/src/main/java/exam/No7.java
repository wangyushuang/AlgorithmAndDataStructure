package exam;//[编程题] 序列最小化
//有一个长度为N的序列。一开始，这个序列是1, 2, 3,... n - 1, n的一个排列。
//
//        对这个序列，可以进行如下的操作：
//
//        每次选择序列中k个连续的数字，然后用这k个数字中最小的数字替换这k个数字中的每个数字。
//
//        我们希望进行了若干次操作后，序列中的每个数字都相等。请你找出需要操作的最少次数。
//
//
//        输入描述:
//        第一行：两个数字n, k，含义如题，满足2 <= k <= n <= 105；
//
//        第二行：n个数字，是1, 2, 3,...n的一个排列。
//
//
//
//        输出描述:
//        一个整数，表示最少的次数。
//
//        输入例子1:
//        2 2
//        2 1
//
//        输出例子1:
//        1

import java.util.Scanner;

public class No7 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int K=in.nextInt();
        int[] list=new int[N];
        for(int i=0;i<N;i++){
            list[i]=in.nextInt();
        }
        //找到list中最小值位置
        int mPos=0;
        int min=list[0];
        for(int i=1;i<list.length;i++){
            if(list[i]<min){
                min=list[i];
                mPos=i;
            }
        }
        int res=0;
        //序列化左边，调整最小值位置
        if(mPos<K){
            res+=1;
            mPos=K-1;
        }else{
            int tmp=(int)Math.ceil(1.0*mPos/(K-1));
            res+=tmp;
            mPos=tmp*(K-1)+1;
        }
        //序列化最小值位置之后的数字
        res+=(int)Math.ceil(1.0*(list.length-mPos-1)/(K-1));
        System.out.println(res);
    }
}
