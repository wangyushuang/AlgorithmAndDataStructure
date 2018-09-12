package classical;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        int[][] nums=new int[6][8];
        LinkedList list=new LinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        System.out.println(list.peek());
        Integer[] arr=new Integer[]{1,2,3};
        List<Integer> al=new ArrayList<>();
        Collections.addAll(al,arr);
        System.out.println(al);
    }
}
