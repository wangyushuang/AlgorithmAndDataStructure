package algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 思路：中间截断，将中点之后链表反转
 */
public class No234 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            ListNode ln = next;
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            while (ln != null) {
                sb.append("->");
                sb.append(ln.val);
                ln = ln.next;
            }
            return sb.toString();
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        int len = 0;
        ListNode tmp = head;
        boolean flag = true;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        int mid = (len % 2 == 0) ? len >> 1 : (len + 1) >> 1;
        tmp = head;
        for (int i = 0; i < mid; i++) {
            tmp = tmp.next;
        }
        //翻转
        ListNode pre = null;
        ListNode cur = tmp;
        ListNode nex;
        while (cur != null) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        //比较pre和head
        cur = pre;
        tmp = head;
        while (cur != null) {
            if (cur.val != tmp.val) {
                flag = false;
                break;
            }
            cur = cur.next;
            tmp = tmp.next;
        }
        //将head还原
        cur = pre;
        pre = null;
        while (cur != null) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return flag;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        System.out.println(head);
        System.out.println(isPalindrome(head));
        System.out.println(head);
        System.out.println((-2>>>1));
    }
}
