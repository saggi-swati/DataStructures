package ds.saggi.in.datastructures;

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

        System.out.println("VerifyBST.main" + isBalanced(tree.root));

        /*boolean isBST = checkIfBST(tree.root);
        System.out.println("If the tree is Binary tree : " + isBST);
        if(isBST) {
            System.out.println("\nPre-order traversal : ");
            preOrderTraversal(tree.root);
            System.out.println("\nIn-order traversal : ");
            inOrderTraversal(tree.root);
            System.out.println("\nPost-order traversal : ");
            postOrderTraversal(tree.root);
        }*/
    }

    private static boolean checkIfBST(Node node) {
        return checkIfBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkIfBSTUtil(Node root, int min, int max) {
        if(root == null) return true;

        int key = root.value;
        if((key < min) || (key > max)) return false;

        return ((root.left == null || checkIfBSTUtil(root.left, min, key)) && (root.right == null || checkIfBSTUtil(root.right, key + 1, max)) );
    }

    private static void inOrderTraversal(Node root) {
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    private static void preOrderTraversal(Node root) {
        if(root == null) return;

        System.out.print(root.value + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void postOrderTraversal(Node root) {
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    private static boolean isBalanced(Node root) {
        if (root == null) return true;

        int leftH = 0;
        int rightH = 0;

        if (root.left != null)
            leftH = height(root.left);
        if (root.right != null)
            rightH = height(root.right);

        if (Math.abs(rightH - leftH) <= 1)
            return isBalanced(root.right) && isBalanced(root.left);

        return false;
    }

    private static int height(Node root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

}
