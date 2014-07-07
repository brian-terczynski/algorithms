package com.brianterczynski.algorithms;

public class RWayTrie<Value> {
    private static final int R = 256;
    private Node<Value> root = new Node<Value>();
    private static class Node<Value> {
        private Value value;
        private Node<Value>[] next = new Node[R];
    }
    
    public void put (String key, Value val) {
        root = put(root, key, val, 0);
    }
    
    private Node<Value> put(Node<Value> curNode, String key, Value val, int d) {
        if (curNode == null) {
            curNode = new Node<Value>();
        }
        if (d == key.length()) {
            curNode.value = val;
            return curNode;
        }
        char c = key.charAt(d);
        curNode.next[c] = put(curNode.next[c], key, val, d+1);
        return curNode;
    }
    
    public boolean contains(String key) {
        return get(key) != null;
    }
    
    public Value get(String key) {
        Node<Value> x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.value;
    }
    
    private Node<Value> get(Node<Value> x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }
}
