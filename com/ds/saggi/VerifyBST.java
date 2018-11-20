package com.ds.saggi;

/**
 * This class constructs below tree and validates if the binary tree is a Binary search tree.
 *          8
 *         / \
 *        6   10
 *       /  \
 *      4    7
 */
public class VerifyBST {

    /**
     * Node representation for a binary tree.
     */
    private static class Node {
        int value;
        Node left, right;

        public Node(int val) {
            this.value = val;
            left = right = null;
        }
    }

    private static class BinaryTree {
        Node root;

        public BinaryTree(int value) {
            root = new Node(value);
        }

        public BinaryTree() {
            root = null;
        }
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(8);
        tree.root.left = new Node(6);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(7);
        tree.root.right = new Node(10);

        System.out.println("If the tree is Binary tree : " + checkIfBST(tree.root));
    }

    private static boolean checkIfBST(Node node) {
        return checkIfBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkIfBSTUtil(Node root, int min, int max) {
        if(root == null) return true;
        System.out.println("processing node " + root.value);

        int key = root.value;
        if((key < min) || (key > max)) return false;

        return ((root.left == null || checkIfBSTUtil(root.left, min, key)) && (root.right == null || checkIfBSTUtil(root.right, key + 1, max)) );
    }
}
