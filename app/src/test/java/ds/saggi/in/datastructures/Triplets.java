package ds.saggi.in.datastructures;

// Java program to find all triplets with given sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Triplets {

    // returns all triplets whose sum is equal to sum value
    private static List<List<Integer>> solution1(int[] nums, int sum) {

        /* Sort the elements */
        Arrays.sort(nums);

        List<List<Integer>> pair = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>();
        List<Integer> triplets = new ArrayList<>();

		/* Iterate over the array from the start and
		consider it as the first element*/
        for (int i = 0; i < nums.length - 2; i++) {

            // index of the first element in the
            // remaining elements
            int j = i + 1;

            // index of the last element
            int k = nums.length - 1;

            while (j < k) {

                if (nums[i] + nums[j] + nums[k] == sum) {

                    String str = nums[i] + ":" + nums[j] + ":" + nums[k];

                    if (!set.contains(str)) {

                        // To check for the unique triplet
                        triplets.add(nums[i]);
                        triplets.add(nums[j]);
                        triplets.add(nums[k]);
                        pair.add(triplets);
                        triplets = new ArrayList<>();
                        set.add(str);
                    }

                    j++; // increment the second value index
                    k--; // decrement the third value index

                } else if (nums[i] + nums[j] + nums[k] < sum)
                    j++;

                else // nums[i] + nums[j] + nums[k] > sum
                    k--;
            }
        }
        return pair;
    }

    /**
     * Optimized
     *
     * @param nums
     * @param totSum
     * @return
     */
    private static List<List<Integer>> solution2(int[] nums, int totSum) {

        Arrays.sort(nums);

        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || (nums[i] != nums[i - 1])) {

                int low = i + 1, high = nums.length - 1, sum = totSum - nums[i];

                while (low < high) {

                    if (nums[low] + nums[high] == sum) {

                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;

                    } else if (nums[low] + nums[high] < sum) low++;

                    else high--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {12, -2, 3, -6, 1, -6, 9, -8, -4, -5};

        List<List<Integer>> triplets = solution1(nums, 0);

        List<List<Integer>> triplets2 = solution2(nums, 0);

        if (!triplets.isEmpty()) {
            System.out.println(triplets);
        }
        if (!triplets2.isEmpty()) {
            System.out.println(triplets2);
        }
    }
}
