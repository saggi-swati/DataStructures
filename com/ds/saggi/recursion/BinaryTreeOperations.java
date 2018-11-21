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
        System.out.println("\nLevel order traversal for a binary tree using queue : ");
        levelOrderTraversalUsingQueue(tree.root);
        System.out.println("\nLevel order traversal for a binary tree using recursion");
        levelOrderTraversalUsingRecursion(tree.root);
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

    /**
     * This method provides a level order traversal for any Binary tree represented by its root node.
     */
    private static void levelOrderTraversalUsingRecursion(Node root) {
        if(root == null) return;
        int height = getHeight(root);
        System.out.println("Height of the tree is : " + height);
        for(int i=1;i<=height;i++)
            depthLevelTraversal(root, i);
    }

    private static void depthLevelTraversal(Node root, int h) {
        if(h == 1) {
            System.out.print( root.value + " ");
            return;
        }
        depthLevelTraversal(root.left, h-1);
        depthLevelTraversal(root.right, h-1);
    }

    private static int getHeight(Node root) {
        if(root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(leftHeight > rightHeight)
            return (leftHeight + 1);
        else
            return (rightHeight + 1);
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

