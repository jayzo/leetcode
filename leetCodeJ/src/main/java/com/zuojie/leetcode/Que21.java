package com.zuojie.leetcode;

import com.zuojie.leetcode.lib.ListNode;

/**
 */
public class Que21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-999);
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode cur = head;
        while(cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 == null && cur2 != null) {
            cur.next = cur2;
        }
        if (cur2 == null && cur1 != null) {
            cur.next = cur1;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        Que21 que = new Que21();
        head = que.mergeTwoLists(head, head2);

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }

    }
}
