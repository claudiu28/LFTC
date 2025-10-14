package main.analizator;

import java.io.PrintWriter;

public class SymbolTableBST {
    private Node root;
    private int nextPosition = 1;

    public static class Node {
        String key;
        int position;
        Node left;
        Node right;

        Node(String key, int position) {
            this.key = key;
            this.position = position;
        }
    }

    public Node insert(Node node, String key) {
        if (node == null) {
            return new Node(key, nextPosition++);
        }
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = insert(node.left, key);
        } else if (compare > 0) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    public int find(Node node, String key) {
        if (node == null) {
            return -1;
        }
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return find(node.left, key);
        } else if (compare > 0) {
            return find(node.right, key);
        }
        return node.position;
    }

    public int add(String key) {
        if (key == null) return -1;
        int position = find(root, key);
        if(position != -1) return position;
        root = insert(root, key);
        return find(root, key);
    }

    public int search(String key) {
        if(key == null) return -1;
        return find(root, key);
    }

    private void inorder(Node node, PrintWriter writer) {
        if (node != null) {
            inorder(node.left, writer);
            writer.println(node.key + " " + node.position);
            inorder(node.right, writer);
        }
    }

    public void writeToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            inorder(root, writer);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
