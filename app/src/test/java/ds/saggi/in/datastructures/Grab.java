package ds.saggi.in.datastructures;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

public class Grab {
    /* ----------------------------------------------------------------------------------------------------------------------------*/

    /**
     * -1,1       0,1     1,1
     * -1,0       x,y     1,0
     * -1,-1      0, -1   1,-1
     */

    private int ROW = 5, COL = 5;

    @Test
    public void findNumberOfIsland() {
        int M[][] = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println("Grab.findNumberOfIsland : " + countIsland(M));
    }

    private boolean checkIfSafe(int r, int c, boolean[][] visited, int[][] M) {
        return (r >= 0 && r < ROW && c >= 0 && c < COL && M[r][c] == 1 && !visited[r][c]);
    }

    private int countIsland(int[][] M) {

        int count = 0;
        boolean[][] visited = new boolean[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    dfs(M, i, j, visited);
                    count++;
                }
            }
        }


        return count;
    }

    private void dfs(int[][] M, int row, int col, boolean[][] visited) {
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        for (int i = 0; i < 8; i++) {
            if (checkIfSafe(row + rowNbr[i], col + colNbr[i], visited, M)) {
                dfs(M, row + rowNbr[i], col + colNbr[i], visited);
            }
        }
    }

    /* ----------------------------------------------------------------------------------------------------------------------------*/

    @Test
    public void findMinMeetingRooms() {
        int start[] = {900, 940, 950, 1100, 1500, 1800};
        int end[] = {910, 1200, 1120, 1130, 1900, 2000};
        int result = 1;
        int count = 1;

        int n = start.length;

        Arrays.sort(start);
        Arrays.sort(end);
        int i = 1, j = 0;
        while (i < n && j < n) {


            if (start[i] <= end[j]) {
                count++;
                i++;

                if (count > result) result = count;
            } else {
                count--;
                j++;
            }
        }
        System.out.println("Grab.findMinMeetingRooms : " + result);
    }

    /* ----------------------------------------------------------------------------------------------------------------------------*/

    static class Node {
        int key;
        Node left;
        Node right;

        // Constructor
        Node(int data) {
            key = data;
            left = null;
            right = null;
        }
    }

    /**
     *              12
     *           /     \
     *        9          15
     *      /   \       /  \
     *     7    10    14    17
     *               /      \
     *              13        19
     */
    private Node createTree() {
        Node root = new Node(12);
        root.left = new Node(9);
        root.right = new Node(15);
        root.left.left = new Node(7);
        root.left.right = new Node(10);
        root.right.left = new Node(14);
        root.right.right = new Node(17);
        root.right.left.left = new Node(13);
        root.right.right.right = new Node(19);

        return root;
    }

    @Test
    public void printVerticalOrderTree() {

        System.out.println("Vertical Order traversal is");

        TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();

        getVerticalOrder(createTree(), map, 0);


        for (Map.Entry e :
                map.entrySet()) {
            System.out.println(e.getValue());
        }

    }

    private void getVerticalOrder(Node root, TreeMap<Integer, Vector<Integer>> m, int hd) {
        if (root == null) return;

        Vector<Integer> get = m.get(hd);
        if (get == null) {
            get = new Vector<>();
            get.add(root.key);

            m.put(hd, get);
        } else
            get.add(root.key);
        getVerticalOrder(root.left, m, hd - 1);
        getVerticalOrder(root.right, m, hd + 1);
    }

    /* ----------------------------------------------------------------------------------------------------------------------------*/

    @Test
    public void checkIfBST() {
        Node root = createTree();

        isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max) {
        if (root == null) return true;

        return root.key >= min && root.key <= max && isBST(root.left, min, root.key - 1) && isBST(root.right, root.key + 1, max);

    }

    /* ----------------------------------------------------------------------------------------------------------------------------*/

    @Test
    public void getNonDuplicate() {

        int[] a = {2, 3, 5, 7, 2, 1, 3, 4, 1, 7, 5};

        int res = 0;
        for (int i : a) {
            res = res ^ i;
        }

        System.out.println("Grab.getNonDuplicate" + res);
    }

    /* ----------------------------------------------------------------------------------------------------------------------------*/

    @Test
    public void testDivisibility() {
        int a[] = {1, 1, 0, 1, 1, 0, 1, 0, 0, 1};

        int n = 3;
        int r = 0;
        for (int i : a) {
            if (i == 0) {
                r = 2 * r % n;
            } else {
                r = (2 * r + 1) % n;
            }

            if (r == 0) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    /* ----------------------------------------------------------------------------------------------------------------------------*/

    @Test
    public void testBalanceParanthesis() {
        String str = "((){}[]([]))";

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a == '{' || a == '[' || a == '(') {
                s.push(a);
            } else {
                if (s.isEmpty()) {
                    System.out.println("false");
                    return;
                } else if (a != matchingParanthesis(s.pop())) {
                    System.out.println("false");
                    return;
                }
            }
        }

        if (s.isEmpty()) System.out.println("true");
        else System.out.println("false");
    }

    private char matchingParanthesis(char p) {
        switch (p) {
            case '{':
                return '}';
            case '[':
                return ']';
            case '(':
                return ')';
        }
        return '-';
    }

    /* ----------------------------------------------------------------------------------------------------------------------------*/

    @Test
    public void levelOrderTraversal() {
        Node root = createTree();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {

            Node ele = q.poll();

            if (ele != null) {
                System.out.print(ele.key + " ");
                if (ele.left != null) {
                    q.add(ele.left);
                }
                if (ele.right != null) {
                    q.add(ele.right);
                }
            }
        }
    }

    /* ----------------------------------------------------------------------------------------------------------------------------*/

    @Test
    public void testHeightOfBST() {
        Node root = createTree();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        int count = 1;
        while (!q.isEmpty()) {

            Node ele = q.poll();

            if (ele != null) {
                System.out.print(ele.key + " ");
                if (ele.left != null) {
                    q.add(ele.left);
                }
                if (ele.right != null) {
                    q.add(ele.right);
                }
            } else if(!q.isEmpty()) {
                count++;
                q.add(null);
            }
        }
        System.out.println(count);
    }

    /* ----------------------------------------------------------------------------------------------------------------------------*/

    @Test
    public void printRightView() {
        Node root = createTree();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        System.out.println(root.key + " ");

        q.add(null);

        while (!q.isEmpty()) {

            Node ele = q.poll();

            if (ele != null) {

                if (ele.right != null) {
                    q.add(ele.right);
                }

                if (ele.left != null) {
                    q.add(ele.left);
                }

            } else if (!q.isEmpty()) {

                System.out.print(q.peek().key + " ");
                q.add(null);
                System.out.println();
            }
        }
    }

    /* ----------------------------------------------------------------------------------------------------------------------------*/

    @Test
    public void printLeftViewBST() {
        Node root = createTree();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        System.out.println(root.key + " ");

        q.add(null);

        while (!q.isEmpty()) {

            Node ele = q.poll();

            if (ele != null) {
                if (ele.left != null) {
                    q.add(ele.left);
                }

                if (ele.right != null) {
                    q.add(ele.right);
                }


            } else if (!q.isEmpty()) {

                System.out.print(q.peek().key + " ");
                q.add(null);
                System.out.println();
            }
        }
    }

    /* ----------------------------------------------------------------------------------------------------------------------------*/

    /** Constructed skewed binary tree is
     *           10
     *          /
     *         8
     *        /
     *       7
     *      /
     *     6
     *    /
     *   5
     */
    private Node createBalancedBST(){
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(7);
        root.left.left.left = new Node(6);
        root.left.left.left.left = new Node(5);

        return root;
    }

    @Test
    public void balacedBST() {
        Node root = createTree();

        Vector<Node> pre = new Vector<>();
        inorder(root, pre);

        buildBST(pre, 0, pre.size());
    }

    private void buildBST(Vector<Node> v, int start, int end) {
        if(start > end) return;
    }

    private void inorder(Node root, Vector<Node> v){
        if(root == null) return;

        inorder(root.left, v);
        v.add(root);
        System.out.print(root.key + " ");
        inorder(root.right, v);
    }

    @Test
    public void checkIfBalancedTree() {
        Node root = createTree();

        Node root2 = createBalancedBST();

        System.out.println(isBalanceUtil(root));
        System.out.println(isBalanceUtil(root2));
    }

    private boolean isBalanceUtil(Node root) {
        if(root == null) return true;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        return Math.abs(lh -rh) <=1 && isBalanceUtil(root.left) && isBalanceUtil(root.right);
    }

    private int getHeight(Node root) {
        if(root == null) return 0;

        return 1+ Math.max(getHeight(root.left), getHeight(root.right));
    }

    @Test
    public void getCurrency() {
        String str = "150000000.654";

        // Format currency for Canada locale in Canada locale,
        // the decimal point symbol is a comma and currency
        // symbol is $.
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
        String currency = format.format(Double.valueOf(str));
        System.out.println("Currency in Canada : " + currency);

        // Format currency for Germany locale in German locale,
        // the decimal point symbol is a dot and currency symbol
        // is €.
        format = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        currency = format.format(Double.valueOf(str));
        System.out.println("Currency in Germany: " + currency);
    }
}
