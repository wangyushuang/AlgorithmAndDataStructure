package algorithm.leetcode;

/**
 * 问题描述
 * 给定两个链表分别代表两个非负整数，链表的每个结点分别存储整数的每位数字，且是逆序存储，即：数字最低位存储在链表表头，数字最高位存储在链表表尾。求解这两个整数的和并以相同的链表形式返回计算的结果。
 * <p>
 * 例如：   输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)   输出：7 -> 0 -> 8
 * Created by WYS on 2018/6/1.
 */
public class No2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode res = new ListNode(0);
        ListNode pNode = res;
        int c = 0;//进位
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + c;
            c = sum / 10;
            sum = sum % 10;
            pNode.next = new ListNode(sum);
            pNode = pNode.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        //处理剩余的长链
        p1 = (p1 == null) ? p2 : p1;
        while (p1 != null) {
            int sum = p1.val + c;
            c = sum / 10;
            sum = sum % 10;
            pNode.next = new ListNode(sum);
            pNode = pNode.next;
            p1 = p1.next;
        }
        if (c > 0)
            pNode.next = new ListNode(c);
        return res.next;
    }
}



