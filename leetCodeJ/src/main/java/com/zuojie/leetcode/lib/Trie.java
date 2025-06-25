package com.zuojie.leetcode.lib;

import com.zuojie.leetcode.lib.JsonUtil;

class Trie {
    boolean isEnd;
    Trie next[];
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    public void insert(String word) {
        if (this.search(word)) {
            return;
        }
        Trie cur = this;
        for (char s : word.toCharArray()) {
            int idx = s - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new Trie();
            }
            cur = cur.next[idx];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Trie cur = this;
        for (char s : word.toCharArray()) {
            int idx = s - 'a';
            if(cur.next[idx] == null) {
                return false;
            }
            cur = cur.next[idx];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie cur = this;
        for (char s : prefix.toCharArray()) {
            int idx = s - 'a';
            if(cur.next[idx] == null) {
                return false;
            }
            cur = cur.next[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("perl");
//        System.out.println(JsonUtil.toJsonString(trie));
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("appl"));

    }
}