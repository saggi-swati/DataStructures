package ds.saggi.in.datastructures.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class KnightsTour {
    private final static int N = 8;
    private final static int[][] moves = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};
    private static int[][] sol = new int[N][N];
    private static int total = N * N;
    private static Stack<int[]> path = new Stack<>();

    private static int row = -1, col = -1;


    public static void main(String[] args) {

        for (int i = 0; i < N; i++)
            Arrays.fill(sol[i], -1);

        row = Double.valueOf(Math.random() % N).intValue();
        col = Double.valueOf(Math.random() % N).intValue();

        sol[row][col] = 1;

        if (solve(row, col, 2)) {
            System.out.println("KnightsTour - WarnsDrouff");
            printSolution();
        } else
            System.out.println("no result");

    }

    private static boolean solve(int r, int c, int count) {
        if (count > total)
            return true;

        List<int[]> nbrs = neighbors(r, c);

        if (nbrs.isEmpty() && count != total)
            return false;

        // Sorting neighbours bases on their neighbour count.
        Collections.sort(nbrs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        for (int[] nb : nbrs) {
            r = nb[0];
            c = nb[1];
            sol[r][c] = count;
            if (solve(r, c, count + 1)) {
                path.push(new int[]{r, c});
                return true;
            }
            path.pop();
            sol[r][c] = 0;

        }

        return false;
    }

    private static List<int[]> neighbors(int r, int c) {
        List<int[]> nbrs = new ArrayList<>();

        for (int[] m : moves) {
            int x = r + m[0];
            int y = c + m[1];
            if (x >= 0 && y >= 0 && x < N && y < N && sol[x][y] == -1) {
                int num = countNeighbors(x, y);
                nbrs.add(new int[]{x, y, num});
            }
        }
        return nbrs;
    }

    private static int countNeighbors(int r, int c) {
        int num = 0;
        for (int[] m : moves) {
            int x = r + m[0];
            int y = c + m[1];
            if (x >= 0 && y >= 0 && x < N && y < N && sol[x][y] == -1)
                num++;
        }
        return num;
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