package com.ds.saggi.recursion;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeOperations {
    static class Node {
        int value;
        Node left, right;
        Node(int val){
            this.value = val;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;
        BinaryTree(int val) {
            root = new Node(val);
        }

        BinaryTree() {
            root = null;
        }
    }

    public static void main(String args[]) {
        BinaryTree tree = createBinaryTree();
        System.out.println("Maximum value in binary tree is : "+searchMax(tree.root));
        System.out.println("Level order traversal for a binary tree : "+searchMax(tree.root));
        levelOrderTraversalUsingQueue(tree.root);
    }

    /**
     *           8
     *         /   \
     *        6     7
     *      /  \  /  \
     *     14  3 12   17
     */
    private static BinaryTree createBinaryTree() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(8);
        tree.root.left = new Node(6);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(14);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(12);
        tree.root.right.right = new Node(17);

        return tree;

    }

    /**
     * This method provides a level order traversal for any Binary tree represented by its root node.
     */
    private static void levelOrderTraversalUsingQueue(Node root) {
        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node != null) {
                System.out.print(node.value + " ");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    private static int max = Integer.MIN_VALUE;
    private static int searchMax(Node root) {
        if(root == null) return max;

        int leftMax = searchMax(root.left);
        int rightMax = searchMax(root.right);

        if(leftMax > rightMax)
            max = rightMax;
        else
            max = leftMax;

        if(root.value > max)
            max = root.value;

        return max;

    }
}

