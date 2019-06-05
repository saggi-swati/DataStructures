package ds.saggi.in.datastructures.booking;

import java.util.HashMap;

public class SumProblem {

    public static void main(String[] args) {
        int sum = 25;
        int[] arr = {11, 12, 4, 8, 6, 2, 5, 19, 1};

        sum_2Sum(arr, sum);
        sum_3Sum(arr, sum);
    }

    /**
     * Find a pair of integers that sum to a given value
     */
    private static void sum_2Sum(int[] arr, int sum) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int val = sum - arr[i];
            if (map.containsKey(val)) {
                System.out.println("Pairs are : " + arr[i] + " and " + val);
                return;
            } else {
                map.put(arr[i], i);
            }
        }
    }

    /**
     * Find a triplet that sum to a given value
     */
    private static void sum_3Sum(int[] arr, int totsum) {
        int len = arr.length;
        for (int j = 0; j < len - 2; j++) {
            int first = arr[j];
            int sum = totsum - first;
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = j; i < arr.length; i++) {
                int val = sum - arr[i];
                if (map.containsKey(val)) {
                    System.out.println("Triplets are : " + first + " " + arr[i] + " and " + val);
                } else {
                    map.put(arr[i], i);
                }
            }
        }
    }
}
