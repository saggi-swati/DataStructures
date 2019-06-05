package ds.saggi.in.datastructures.recursion;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOperations {
    static class Node {
        int value;
        Node left, right;

        Node(int val) {
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
        System.out.println("Maximum height of the tree without recursion is : " + getHeightWithoutRecursion(tree.root));
        System.out.println("Maximum value in binary tree is using recursion : " + searchMax(tree.root));
        System.out.println("Maximum value in binary tree is using queue : " + searchMaxUsingQueue(tree.root));
        System.out.println("\nLevel order traversal for a binary tree using queue : ");
        levelOrderTraversalUsingQueue(tree.root);
        System.out.println("\nLevel order traversal for a binary tree using recursion");
        levelOrderTraversalUsingRecursion(tree.root);
        insert(tree.root, 10);
        search(tree.root, tree.root.right.left);
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
        tree.root.right.right.right = new Node(19);

        return tree;

    }

    /**
     * This method provides a level order traversal for any Binary tree represented by its root node.
     */
    private static void levelOrderTraversalUsingQueue(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
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
        if (root == null) return;
        int height = getHeight(root);
        System.out.println("Height of the tree is : " + height);
        for (int i = 1; i <= height; i++)
            depthLevelTraversal(root, i);
    }

    private static void depthLevelTraversal(Node root, int h) {
        if (h == 1) {
            if (root != null)
                System.out.print(root.value + " ");
            return;
        }
        depthLevelTraversal(root.left, h - 1);
        depthLevelTraversal(root.right, h - 1);
    }

    private static int getHeight(Node root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight > rightHeight)
            return (leftHeight + 1);
        else
            return (rightHeight + 1);
    }

    private static int max = Integer.MIN_VALUE;

    private static int searchMax(Node root) {
        if (root == null) return max;

        int leftMax = searchMax(root.left);
        int rightMax = searchMax(root.right);

        if (leftMax > rightMax)
            max = leftMax;
        else
            max = rightMax;

        if (root.value > max)
            max = root.value;

        return max;

    }

    private static int searchMaxUsingQueue(Node root) {
        if (root == null) return max;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                if (node.value > max)
                    max = node.value;

                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return max;
    }

    private static void insert(Node root, int data) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left == null) {
                node.left = new Node(data);
                System.out.println("\nNode added as left child of Node : " + node.value);
                break;
            } else if (node.right == null) {
                node.right = new Node(data);
                System.out.println("\nNode added as right child of Node : " + node.value);
                break;
            } else {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    private static void search(Node root, Node data) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null && node.equals(data)) {
                System.out.println("\nNode found : value is " + node.value);
                break;
            } else {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    private static int getHeightWithoutRecursion(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int count = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node != null) {
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            } else if (!q.isEmpty()) {
                count++;
                q.add(null);
            }
        }

        return count;
    }
}
