package com.zuojie.leetcode.lib;

public class CycleArray {
    int start;
    int end;
    int count;
    int size;
    int[] data;
    public CycleArray(int size) {
        start = 0;
        end = 0;
        count = 0;
        this.size = size;
        this.data = new int[size];
    }

    public CycleArray(int[] data) {
        start = 0;
        count = data.length;
        size = data.length;
        end = count;
        this.data = data;
    }

    public void reSize(int size) {

    }

    public boolean empty() {
        return false;
    }

    public int get(int idx) {
        return 0;
    }

    public int getFirst(int idx) {
        return 0;
    }

    public int getLast(int idx) {
        return 0;
    }

    public void addFirst(int idx, int val) {

    }

    public void addLast(int idx, int val) {

    }

    public int removeFirst() {
        return 0;
    }

    public int removeLast() {
        return 0;
    }
}
