package com.zuojie.leetcode;

import com.zuojie.demo.JsonUtil;
import com.zuojie.leetcode.lib.ListNode;

import java.util.*;

public class Que23 {

    public ListNode mergeKLists(ListNode[] lists) {
        final int INV_K = -99999;
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode ret = new ListNode(INV_K);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (int i = 0; i< lists.length; i++) {
            ListNode node = lists[i];
            if (node == null) {
                continue;
            }
            pq.add(node);
        }
        ListNode cur = ret;
        while (!pq.isEmpty()) {
            ListNode one = pq.poll();
            if (one == null) {
                continue;
            }
            cur.next = one;
            cur = cur.next;
            if (one.next != null) {
                pq.add(one.next);
            }
        }
        return ret.next;
    }

    public static void main(String[] args) {
        Que23 que23 = new Que23();
        ListNode[] lists = new ListNode[3];
        // l1: 2 -> 4 -> 6
        // l2: 1-> 5-> 7 ->10;
        // l3: 2 -> 8 -> 9
        lists[0] = new ListNode();
        lists[0].val = 2;
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(6);
        lists[1] = new ListNode();
        lists[1].val = 1;
        lists[1].next = new ListNode(5);
        lists[1].next.next = new ListNode(7);
        lists[1].next.next.next = new ListNode(10);
        lists[2] = new ListNode();
        lists[2].val = 2;
        lists[2].next = new ListNode(8);
        lists[2].next.next = new ListNode(9);
        ListNode result = que23.mergeKLists(lists);
        System.out.printf(JsonUtil.toJsonString(result));

    }
}
