package com.cszjo.leetcode.tree;

public class Trie {

    private Trie[] t = new Trie[26];
    private boolean endOfWord;

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie tmp = this;
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if (tmp.t[c - 'a'] == null) {
                tmp.t[c - 'a'] = new Trie();
            }
            tmp = tmp.t[c - 'a'];
        }
        tmp.endOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie tmp = this;
        for (char c : word.toCharArray()) {
            tmp = tmp.t[c - 'a'];
            if (tmp == null) {
                return false;
            }
        }
        return tmp.endOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie tmp = this;
        for (char c : prefix.toCharArray()) {
            tmp = tmp.t[c - 'a'];
            if (tmp == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        boolean app = trie.search("app");
        System.out.println(app);
    }
}
