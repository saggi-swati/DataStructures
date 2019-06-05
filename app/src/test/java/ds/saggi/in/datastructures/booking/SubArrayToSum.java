package ds.saggi.in.datastructures.booking;

/**
 * Given a list of numbers, write a function that would return the consecutive sequence
 * of that list that sums up to a specific number.
 */
public class SubArrayToSum {

    private static int findSubArrayMaxSum(int[] arr) {
        int i = 0;
        int len = arr.length;

        while(arr[i]<=0) i++;

        int start = i, s = i;
        int end = i, e = i;

        int max = arr[i];
        int sum = max;

        while(i < len) {
            sum = sum + arr[i];
            e = i;

            if(sum > max) {
                max = sum;
                end = i;
                start = s;
            } else if(sum <=0) {
                sum = 0;
                s = i+1;
                e = i+1;
            }
            i++;
        }

        System.out.println("SubArrayToSum.findSubArrayForMaxSum : from " + start + " to " + end);

        return max;
    }

    public static int maxSubArray(int[] A) {
        if(A == null || A.length == 0) return Integer.MIN_VALUE;
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    private static void findSubArrayForSum(int[] arr, int sum) {
        int i = 1, start = 0;
        int len = arr.length;
        int arrSum = arr[0];
        for (; i < len; i++) {
            while (arrSum > sum && start < i - 1) {
                arrSum -= arr[start];
                start++;
            }

            if (arrSum == sum) {
                System.out.println("SubArrayToSum.findSubArrayForSum : from " + start + " to " + (i - 1));
                return;
            }

            arrSum += arr[i];
        }
    }



    public static void main(String[] args) {
        int sum = 20;

        int[] arr = {-10, -15, -19, 4, 3, 17, 8, 1, -19, 16, -18, 41, -52};
        findSubArrayForSum(arr, sum);
        System.out.println( "Max sum " + findSubArrayMaxSum(arr));
        System.out.println("SubArrayToSum.main" + maxSubArray(arr));
    }

    public int strStr(String h, String n) {
        if(h == null || h.isEmpty() || n == null || n.isEmpty()) {
            return 0;
        }
        int n1 = h.length(), n2 = n.length();
        int i = 0;
        for(;i<n1-n2;i++) {
            if(n.charAt(0) == h.charAt(i) && (h.substring(i, i+n2)).equals(n))
                return i;
        }

        return -1;
    }

}
