package ds.saggi.in.datastructures;

import java.util.Stack;

/**
 * Time complexity is O(2^n-1)
 * best case - n=1 - O(1)
 *
 * Implementation for Tower of Hanoi problem <br>
 * Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:<br>
 * 1) Only one disk can be moved at a time.<br>
 * 2) Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.<br>
 * 3) No disk may be placed on top of a smaller disk.<br>
 */
public class TowerOfHanoi {
    public static void main(String args[]) {
        towerOfHanoi(4, 'A', 'C', 'B');
    }

    /**
     * This is a recursive call to move the disk from fromRod to toRod using an auxRod.
     *
     * @param n - Number of disks
     * @param fromRod - from tower
     * @param toRod - to tower
     * @param auxRod - intermediate tower.
     */
    private static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if(n == 1) {
            System.out.println("Moving from tower " + fromRod + " to tower " + toRod);
            return;
        }

        towerOfHanoi(n-1, fromRod, auxRod, toRod);
        System.out.println("Moving from tower " + fromRod + " to tower " + toRod);
        towerOfHanoi(n-1, auxRod, toRod, fromRod);
    }

    private static void maxRectangle(int[] hist) {

        int n = hist.length;
        int max = 0;
        int area = 0;

        Stack<Integer> s = new Stack<>();

        int i = 0;

        while(i < n) {
            if(s.isEmpty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            } else {
                int p = s.pop();

                area = hist[p]*(s.isEmpty()?i:i-s.peek()-1);

                if(area > max)
                    max = area;
            }
        }

        while(!s.isEmpty()) {
            int p = s.pop();

            area = hist[p]*(s.isEmpty()?i:i-s.peek()-1);

            if(area > max)
                max = area;
        }

        System.out.println("TowerOfHanoi.maxRectangle : " + area);
    }
}
