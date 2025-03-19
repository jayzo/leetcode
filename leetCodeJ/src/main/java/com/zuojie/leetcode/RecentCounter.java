package com.zuojie.leetcode;

import java.util.*;

/**
 * que 933
 */
public class RecentCounter {
    Queue<Integer> listT;
    public RecentCounter() {
        listT = new LinkedList<>();
    }

    public int ping(int t) {
        listT.add(t);
        int target = t-3000;
        while (listT.peek() < target) {
            listT.remove();
        }
        return listT.size();
    }

    public static void main(String[] args) {
        RecentCounter que = new RecentCounter();
        System.out.println(que.ping(1));
        System.out.println(que.ping(5));
        System.out.println(que.ping(6));
        System.out.println(que.ping(3000));
        System.out.println(que.ping(3002));

    }
}
