package ds.saggi.in.datastructures;

import org.junit.Test;

import java.util.Arrays;

public class Sorting {

    @Test
    public void insertionSort() {
        int arr[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};
        int n = 10;
        int num = arr[n - 1];
        int i = 0;
        for ( i = n - 2; i >= 0; i--) {
            if (arr[i] > num)
                arr[i + 1] = arr[i];
            else {
                arr[i + 1] = num;
                break;
            }
            printArray(arr);
            System.out.println();
        }

        if(i < 0) arr[0] = num;

        printArray(arr);

    }

    private void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void insertionSort2() {
        int a[] = {2, 3, 4, 1, 6, 7, 8, 9, 10, 5};
        int n = 10;
        for(int i = 1;i<n;i++) {
            /*for(int j = 0; j<i;j++) {
                if(a[j] > a[i]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }*/

            int j = 0;
            while(j<i) {
                if(a[j] > a[i]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
                j++;
            }
        }

        printArray(a);
    }

    @Test
    public void quickSort() {
        int a[] = {19, 3, 14, 13, 6, 17, 1, 12, 10, 15};
        sort(a, 0, a.length-1);

        printArray(a);
    }

    private int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    @Test
    public void countingSort() {
        int arr[] = {63,54,17,78,43,70,32,97,16,94,74,18,60,61,35,83,13,56,75,52,70,12,24,37,17,0,16,64,34,81,82,24,69,2,30,61,83,37,97,16,70,53,0,61,12,17,97,67,33,30,49,70,11,40,67,94,84,60,35,58,19,81,16,14,68,46,42,81,75,87,13,84,33,34,14,96,7,59,17,98,79,47,71,75,8,27,73,66,64,12,29,35,80,78,80,6,5,24,49,82};
        int max = -1;
        int n = arr.length;
        for(int i = 0;i<n;i++)
            max = Math.max(n, Math.max(max, arr[i])+1);

        int[] a = new int[max+1];

        Arrays.fill(a, 0);

        for(int i = 0;i< n;i++) {
            a[arr[i]]++;
        }
        System.out.println("Sorting.countingSort" + Arrays.toString(a));
    }

    @Test
    public void marcsCakewalk() {
        int[] c = {7,4,9,6};
        int n = c.length;
        long total = 0;
        boolean[] v = new boolean[n];

        for(int i = 0;i<n;i++) {
            int j = findMax(c, v);
            v[j] = true;
            System.out.println("Sorting.marcsCakewalk" + Math.pow(2,i));

            total = total + c[j] * (long)Math.pow(2,i);
        }
        System.out.println("Sorting.marcsCakewalk" + total);
    }

    private int findMax(int[] c, boolean[] v) {
        int max = -1;
        int index = -1;
        for(int i = 0; i< c.length;i++) {
            if(!v[i] && c[i] > max){
                max = c[i];
                index = i;
            }
        }

        return index;
    }

    @Test
    public void gridChallenge() {

        String grid[] = {
                "uxf","vof","hmp"       // fux   fov    hmp
        };

        int n = grid.length;
        char[] min = new char[n];
        min[0] = findMin(grid[0]);
        for(int i = 1;i< n;i++) {
            min[i] = findMin(grid[i]);
            if(min[i-1] > min[i]) {
                System.out.println("Sorting.gridChallenge : " + "NO");
                return;
            }

        }

        System.out.println("Sorting.gridChallenge : " + "YES");

    }

    private char findMin(String s) {
        int min = 0;
        char minChar = s.charAt(0);
        for(int i = 0;i<s.length();i++) {
            char c = s.charAt(i);
            if( c < minChar) {
                min = i;
                minChar = c;
            }
        }

        return minChar;
    }
}
