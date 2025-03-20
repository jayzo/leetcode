package com.zuojie.leetcode;

import com.zuojie.leetcode.lib.ListNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 */
public class Que19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode pre = head;
        ListNode fw = head;
        int step = 0;
        while(fw != null) {
            fw = fw.next;
            if (step < n) {
                step++;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        if (pre == cur) {
            head = head.next;
        } else {
            pre.next = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Que19 que19 = new Que19();
        head = que19.removeNthFromEnd(new ListNode(1), 1);

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }

    }
}
