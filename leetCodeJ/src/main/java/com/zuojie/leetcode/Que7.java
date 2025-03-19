package com.zuojie.leetcode;

/**
 */
public class Que7 {
    public int reverse(int x) {
        boolean needMinus = x < 0;
        if (needMinus) {
            x = x * -1;
        }
        int floor = String.valueOf(x).length() - 1;
        long ret = 0L;

        while (x > 0) {
            long bit = x % 10;
            x = x / 10;
            ret += bit * Math.pow(10, floor);
            floor--;
        }
        if (needMinus && ret > Math.pow(2, 31)) {
            return 0;
        }
        if (!needMinus && ret > Math.pow(2, 31) -1) {
            return 0;
        }
        return needMinus ? (int)(ret * -1) : (int)ret;
    }

    public static void main(String[] args) {
        Que7 que = new Que7();
        int n = -9876;
        int m = que.reverse(n);
        System.out.println(m);
        System.out.println(que.reverse(0));
        System.out.println(que.reverse(123));
        System.out.println(que.reverse(-123));
        System.out.println(que.reverse(8899977));
    }
}
