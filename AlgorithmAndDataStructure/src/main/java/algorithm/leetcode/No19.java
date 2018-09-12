package algorithm.leetcode;

import org.junit.Test;



public class No19 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        public String toString(){
            ListNode ln=next;
            StringBuilder sb=new StringBuilder();
            sb.append(val);
            while(ln!=null){
                sb.append("->");
                sb.append(ln.val);
                ln=ln.next;
            }
            return sb.toString();
        }
    }
    @Test
    public void test() {
        ListNode node=new ListNode(0);
        ListNode tmp=node;
        tmp.next=new ListNode(1);
        tmp=tmp.next;
        tmp.next=new ListNode(2);
        tmp=tmp.next;
        tmp.next=new ListNode(3);
        node=removeNthFromEnd(node,1);
        System.out.println(node);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nhead = head;
        ListNode rhead = head;
        int j = 0;

        while (head != null) {
            head = head.next;
            if (j > n) nhead = nhead.next;
            j++;
        }
        if (j <= n) rhead = nhead.next;
        else nhead.next = nhead.next.next;
        return rhead;
    }
}
