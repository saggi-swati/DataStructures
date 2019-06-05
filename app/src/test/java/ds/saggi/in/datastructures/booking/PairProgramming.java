package ds.saggi.in.datastructures.booking;


import java.util.Arrays;

public class PairProgramming {

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1500, 1520, 1530, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + findPlatform(arr, dep, n));
    }

    /**
     * Maximum no of platforms on a railway station, if we are giving arrival time and departure time of Train
     */
    private static int findPlatform(int[] arr, int[] dep, int n) {
        int plat_needed = 1, res = 1;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;

                if (plat_needed > res)
                    res = plat_needed;
            } else {
                plat_needed--;
                j++;
            }
        }

        return res;
    }
}
