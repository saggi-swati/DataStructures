package ds.saggi.in.datastructures.recursion;

/**
* This class validates if an array is sorted using recursion.
*/
public class CheckSortedArray {
  private static int[] arr = {4,9,10,13,16,20};
  
  public static void main(String args[]) {
    System.out.println("If the array is sorted : " + checkIfSortedArray(0));
  }
  
  private static int checkIfSortedArray(int index) {
  
    if(arr == null || arr.length == 0) return 0;
    
    int len = arr.length;
    if(len == 1) return 1;
    
    if(index >= len -1) return 1;
    
    return arr[index] > arr[index + 1] ? 0 :checkIfSortedArray(index +1) ;
  }
}
