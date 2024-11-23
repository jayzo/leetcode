package com.zuojie.leetcode.add_two_numbers;

import java.util.Objects;

/**
 * @author zhili ZUOJIE
 * @date 2020/3/29
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode current = null;
        int borrow = 0;
        while (true) {
            ListNode next = null;
            if (Objects.nonNull(l1) && Objects.nonNull(l2)) {
                if(l1.val + l2.val + borrow >= 10){
                    next = new ListNode(l1.val+l2.val + borrow - 10);
                    borrow = 1;
                }else {
                    next = new ListNode(l1.val+l2.val + borrow);
                    borrow = 0;
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if (Objects.nonNull(l1)) {
                if(l1.val + borrow >= 10){
                    next = new ListNode(l1.val + borrow - 10);
                    borrow = 1;
                }else {
                    next = new ListNode(l1.val + borrow);
                    borrow = 0;
                }
                l1 = l1.next;
            } else if (Objects.nonNull(l2)) {
                if(l2.val + borrow >= 10){
                    next = new ListNode(l2.val + borrow - 10);
                    borrow = 1;
                }else {
                    next = new ListNode(l2.val + borrow);
                    borrow = 0;
                }
                l2 = l2.next;
            } else if(borrow > 0){
                next = new ListNode(borrow);
                borrow = 0;
            }
            if(Objects.isNull(next)){
                break;
            }
            if(Objects.isNull(res)){
                res = next;
                current = next;
            }else{
                current.next = next;
                current = current.next;
            }
        }
        return res;
    }
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }
}
