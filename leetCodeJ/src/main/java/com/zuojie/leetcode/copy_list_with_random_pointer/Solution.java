package com.zuojie.leetcode.copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author zhili ZUOJIE
 * @date 2020/4/11
 */
public class Solution {

    public Node copyRandomList2(Node head) {
        Node ret = null;
        Node current = head;
        Node retCurrent = null;
        Node retHead = null;
        if(Objects.isNull(head)){
            return retHead;
        }
        Map<Node,Node> dict = new HashMap<>(16);
        while(Objects.nonNull(current)){
            ret = new Node(current.val);
            dict.put(current, ret);
            if(Objects.isNull(retHead)){
                retHead = ret;
                retCurrent = retHead;
            }else{
                retCurrent.next = ret;
                retCurrent = ret;
            }
            if(Objects.nonNull(current.next)){
                if(dict.containsKey(current.next)){
                    ret.next = dict.get(current.next);
                }else {
                    ret.next = new Node(current.next.val);
                }
            }
            current = current.next;
        }
        current = head;
        retCurrent = retHead;
        while(Objects.nonNull(current)){
            if(dict.containsKey(current.random)){
                retCurrent.random = dict.get(current.random);
            }
            current = current.next;
            retCurrent = retCurrent.next;
        }
        return retHead;
    }
    public static void main(String[] args){
        Node head = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n1.random = head;
        n2.random = n4;
        n3.random = n2;
        n4.random = head;
        Solution solution = new Solution();
        Node ret = solution.copyRandomList2(head);
        System.out.println(ret.val);
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}