package com.brianterczynski.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTree <T extends Comparable<T>> {
    private class Node {
        T value;
        Node left;
        Node right;
    }
    
    private Node root;

    public void insert (T value) {
        root = insert(value, root);
    }
    
    public BinarySearchTree<T> reverse () {
        BinarySearchTree<T> revTree = new BinarySearchTree<T>();
        revTree.root = reverse(root);
        return revTree;
    }
    
    private Node reverse (Node n) {
        if (n == null) {
            return null;
        }
        Node newNode = new Node();
        newNode.value = n.value;
        newNode.left = reverse(n.right);
        newNode.right = reverse(n.left);
        return newNode;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder ();
        Deque<Node> q = new ArrayDeque<Node> ();
        q.add(root);
        while (!q.isEmpty()) {
            Node n1 = q.remove();
            if (n1 == null) {
                sb.append(":null:");
            } else {
                sb.append(":").append(n1.value).append(":");
                if (n1.left == null) {
                    sb.append("left is null");
                } else {
                    q.add(n1.left);
                }
                if (n1.right == null) {
                    sb.append("right is null");
                } else {
                    q.add(n1.right);
                }
            }
        }
        return sb.toString();
    }
    
    public boolean search (T value) {
        return search (value, root) != null;
    }

    public T minimum () {
        Node minNode = minimum(root);
        if (minNode != null) {
            return minNode.value;
        } else {
            return null;
        }
    }
    
    private Node minimum(Node node) {
        if (node == null) {
            return null;
        }
        Node curNode = node;
        while (curNode.left != null) {
            curNode = curNode.left;
        }
        return curNode;
    }
    
    public T maximum () {
        Node maxNode = maximum(root);
        if (maxNode != null) {
            return maxNode.value;
        } else {
            return null;
        }
    }
    
    private Node maximum(Node node) {
        if (node == null) {
            return null;
        }
        Node curNode = node;
        while (curNode.left != null) {
            curNode = curNode.left;
        }
        return curNode;
    }
    
    public void delete (T value) {
        root = delete(value, root);
    }
    
    public void deleteMin () {
        if (root == null) {
            return;
        }
        if (root.left == null) {
            root = null;
        } else {
            deleteMin(root);
        }
    }
    
    private Node deleteMin(Node curNode) {
        if (curNode.left == null) {
            return curNode.right;
        }
        curNode.left = deleteMin(curNode.left);
        return curNode;
    }

    private Node delete (T value, Node curNode) {
        if (curNode == null) {
            return null;
        }
        int cmp = value.compareTo(curNode.value);
        if (cmp < 0) {
            curNode.left = delete(value, curNode.left);
        } else if (cmp > 0) {
            curNode.right = delete(value, curNode.right);
        } else {
            if (curNode.right == null) {
                return curNode.left;
            } else if (curNode.left == null) {
                return curNode.right;
            } else {
                Node temp = curNode;
                curNode = minimum(temp.right);
                curNode.right = deleteMin(temp.right);
                curNode.left = temp.left;
            }
        }
        return curNode;
    }

    private Node search (T value, Node curNode) {
        if (curNode == null) {
            return null;
        }
        if (curNode.value.equals(value)) {
            return curNode;
        } else if (curNode.value.compareTo(value) < 0) {
            return search(value, curNode.left);
        } else {
            return search(value, curNode.right);
        }
    }

    private Node insert (T value, Node root) {
        if (root == null) {
            Node node = new Node();
            node.value = value;
            return node;
        } else if (value.compareTo(root.value) < 0) {
            root.left = insert(value, root.left);
        } else {
            root.right = insert(value, root.right);
        }
        return root;
    }
}
