package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字
 * Created by WYS on 2018/6/1.
 */

// Definition for singly-linked list.


public class No82 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pHead = new ListNode(0);
        ListNode pCurr = pHead;
        ListNode pNext = head;
        while (pNext != null) {
            int tmp = pNext.val;
            if(pNext.next!=null && pNext.next.val==tmp){
                while(pNext!=null && pNext.val==tmp){
                    pNext=pNext.next;
                }
            }else{
                pCurr.next=new ListNode(tmp);
                pCurr=pCurr.next;
                pNext=pNext.next;
            }

        }
        return pHead.next;
    }
}
