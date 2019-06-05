package ds.saggi.in.datastructures.backtracking;


import java.util.Arrays;
import java.util.Stack;

/**
 * ._____________________________________________________
 * | 0   |  59  |  38  |  33  |  30  |  17  |  8   |  63 |
 * |-----|------|------|------|------|------|------|-----|
 * | 37  |  34  |  31  |  60  |  9   |  62  |  29  |  16 |
 * |-----|------|------|------|------|------|------|-----|
 * | 58  |  1   |  36  |  39  |  32  |  27  |  18  |  7  |
 * |-----|------|------|------|------|------|------|-----|
 * | 35  |  48  |  41  |  26  |  61  |  10  |  15  |  28 |
 * |-----|------|------|------|------|------|------|-----|
 * | 42  |  57  |  2   |  49  |  40  |  23  |  6   |  19 |
 * |-----|------|------|------|------|------|------|-----|
 * | 47  |  50  |  45  |  54  |  25  |  20  |  11  |  14 |
 * |-----|------|------|------|------|------|------|-----|
 * | 56  |  43  |  52  |  3   |  22  |  13  |  24  |  5  |
 * |-----|------|------|------|------|------|------|-----|
 * | 51  |  46  |  55  |  44  |  53  |  4   |  21  |  12 |
 * |_____|______|______|______|______|______|______|_____|
 */
public class KnightsTour {

    private static final int N = 8;
    private static int[][] sol = new int[N][N];
    private static int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

    private static Stack<int[]> path = new Stack<>();

    private static int row = -1, col = -1;

    public static void main(String[] args) {

        setStartPoint();

        // Backtracking Approach
        for (int i = 0; i < N; i++)
            Arrays.fill(sol[i], -1);
        KnightsTourBacktracking();

    }

    private static void KnightsTourBacktracking() {

        sol[row][col] = 1;

        if (findKTUtil(row, col, 2)) {
            System.out.println("KnightsTour - Backtracking");
            printSolution();
        } else
            System.out.println("KnightsTour.KnightsTourBacktracking :  No valid path to traverse");
    }

    private static boolean findKTUtil(int x, int y, int move) {
        int nextX, nextY;

        if (move > N * N) return true;


        for (int i = 0; i < N; i++) {
            nextX = x + xMove[i];
            nextY = y + yMove[i];

            if (isValidMove(nextX, nextY)) {
                sol[nextX][nextY] = move;
                if (findKTUtil(nextX, nextY, move + 1)) {
                    path.push(new int[]{nextX, nextY});
                    return true;
                } else
                    sol[nextX][nextY] = -1;
            }
        }
        return false;
    }

    private static boolean isValidMove(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N && sol[x][y] == -1;
    }

    private static void setStartPoint() {
        row = Double.valueOf(Math.random() % N).intValue();
        col = Double.valueOf(Math.random() % N).intValue();
    }

    private static void printSolution() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(sol[i]));
        }

        path.push(new int[]{row, col});
        while (!path.isEmpty()) {
            System.out.print(Arrays.toString(path.pop()) + " ");
        }
    }
}
