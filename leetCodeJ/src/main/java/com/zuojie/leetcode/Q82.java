package com.zuojie.leetcode;

import java.util.*;

public class Q82 {
    public ListNode deleteDuplicates(ListNode head) {

        int nullKey = -999;

        if (Objects.isNull(head)) {
            return null;
        }
        ListNode ret = new ListNode(nullKey);
        ListNode dup = new ListNode(nullKey);
        ListNode cur = head;
        ListNode retCur = ret;
        while (Objects.nonNull(cur)) {
            if ((Objects.nonNull(cur.next) && cur.val == cur.next.val) || cur.val == dup.val) {
                dup.next = new ListNode(cur.val);
                dup = dup.next;
            } else {
                retCur.next = new ListNode(cur.val);
                retCur = retCur.next;
            }
            cur = cur.next;
        }

        return ret.next;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,3,4,4,5);
//        List<Integer> list = Arrays.asList(1,1,1,2,3);
        ListNode head = new ListNode(-999);
        ListNode cur = head;
        for (Integer o : list) {
            cur.next = new ListNode(o);
            cur = cur.next;
        }
        Q82 q82 = new Q82();
        ListNode res = q82.deleteDuplicates(head.next);
        while(true) {
            if (Objects.isNull(res)) {
                break;
            }
            System.out.println(res.val);
            res = res.next;
        }
    }
}
