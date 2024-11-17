package com.zuojie.coupang;

import java.util.ArrayList;
import java.util.List;

public class CoupangDemo {
    public static void main(String[] args) {
        System.out.println("aaa");
        int[] a = {1,2,3,4};
        List<Integer> l = arr2List(a);
        System.out.println(l);
    }

    private static List<Integer> arr2List(int[] arr) {
        List<Integer> ret = new ArrayList<>(arr.length);
        for (int j : arr) {
            ret.add(j);
        }
        return ret;
    }
}
