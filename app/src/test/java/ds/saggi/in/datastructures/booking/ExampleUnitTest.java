package ds.saggi.in.datastructures.booking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    // TODO: Incomplete
    private static void readLargeFile() {
        FileInputStream inputStream = null;
        Scanner sc = null;

        try {
            inputStream = new FileInputStream("Path to file");
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                if (line.contains("ERROR"))
                    System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

    private static void pascalTraingle() {
        int A = 6;
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();


        for (int i = 0; i < A; i++) {
            ArrayList<Integer> x = new ArrayList<>();
            int C = 1;
            for (int j = 1; j <= i + 1; j++) {
                x.add(C);
                C = C * (i + 1 - j) / j;
            }
            a.add(x);
        }

        for (int i = 0; i < a.size(); i++) {
            for (int p :
                    a.get(i)) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }

    private static int getPascalValue(int row, int column) {
        if (column == 0 || column == row) {
            return 1;
        }
        return getPascalValue(row - 1, column - 1) + getPascalValue(row - 1, column);
    }

    private static void getFirstNonRepeatedCharInString() {
        String line = "read data structures parctice";


        int NO_OF_CHAR = 256;
        int[] arr = new int[NO_OF_CHAR];

        for (int i = 0; i < NO_OF_CHAR; i++) {
            arr[i] = -1;
        }

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (arr[c] == -1) {
                arr[c] = i;
            } else {
                arr[c] = -2;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < NO_OF_CHAR; i++) {
            if (arr[i] >= 0) {
                res = (res > arr[i]) ? arr[i] : res;
            }
        }

        if (res >= 0 && res < line.length())
            System.out.println("getFirstNonRepeatedCharInString -- " + line.charAt(res));
        else
            System.out.println("getFirstNonRepeatedCharInString -- Char not found");
    }

    private static void findSubArrayForSum() {
        int sum = 20;

        int[] arr = {10, 15, 19, 4, 7, 8, 1, 19, 16, 18, 1};

        int n = arr.length;
        int start = 0, i;

        int curr_sum = arr[0];


        for (i = 1; i < n; i++) {

            while (curr_sum > sum && start < i - 1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            if (curr_sum == sum) {
                System.out.println("findSubArrayForSum :  FOUND from " + start + " to " + (i - 1));
                return;
            }

            curr_sum += arr[i];
        }

        if (curr_sum == sum) {
            System.out.println("findSubArrayForSum :  FOUND from " + start + " to " + (i - 1));
        } else {
            System.out.println("findSubArrayForSum : Not FOUND");
        }
    }

    private static void unmodifiableCollection() {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        modifyList(Collections.unmodifiableList(a));
        System.out.println("unmodifiableCOllection : " + Arrays.toString(a.toArray()));
    }

    private static void modifyList(List<Integer> a) {
        try {
            a.add(4);
        } catch (UnsupportedOperationException e) {
            // Exception if not supported.
        }
        System.out.println("modifyList : " + Arrays.toString(a.toArray()));
    }

    private static void lengthOfLongestSubstring() {
        String s = "@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCD";
        if (s == null || s.isEmpty()) return;
        int len = s.length();

        if (len == 1) return;


        int max_len = 1;
        int index = 0;
        int cur_len = 1;
        final int MAX_NO_CHARS = 256;
        int[] visited = new int[MAX_NO_CHARS];
        int i;


        Arrays.fill(visited, -1);

        visited[s.charAt(0)] = 0;

        for (i = 1; i < len; i++) {
            index = visited[s.charAt(i)];

            if (index == -1 || i - cur_len > index) {
                cur_len++;
            } else {
                if (cur_len > max_len) {
                    max_len = cur_len;
                }

                cur_len = i - index;
            }

            visited[s.charAt(i)] = i;
        }

        System.out.println("lengthOfLongestSubstring : " + max_len);
    }

    private static double findMedianSortedArrays() {

        int a[] = {1, 6, 19, 31, 44};
        int b[] = {5, 18, 21, 25, 29, 36, 55, 91, 110};

        int len1 = a.length;
        int len2 = b.length;

        if (len1 == 0)
            return findMedian(b);
        if (len2 == 0)
            return findMedian(a);

        int size = (len1 + len2);
        int[] m = new int[size];
        int i = 0, j = 0, k = 0;

        while (i < len1 && j < len2) {
            if (a[i] < b[j]) {
                m[k] = a[i];
                i++;
            } else {
                m[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            m[k] = a[i];
            i++;
            k++;
        }

        while (j < len2) {
            m[k] = b[j];
            j++;
            k++;
        }

        return findMedian(m);


    }

    private static double findMedian(int[] a) {
        int len = a.length;

        if (len % 2 == 0)
            return (a[len / 2] + a[(len / 2) - 1]) / 2;
        else
            return a[len / 2];
    }

    private static int longestPalSubstr(String str) {
        int maxLength = 1; // The result (length of LPS)

        int start = 0;
        int len = str.length();

        int low, high;

        // One by one consider every character as center
        // point of even and length palindromes
        for (int i = 1; i < len; ++i) {
            // Find the longest even length palindrome with
            // center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with
            // center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);

        return maxLength;
    }

    private static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }

    private static int revInteger(int num) {

        String reverse = "";
        String n = "";

        if (num < 0)
            n = String.valueOf(num * -1);
        else
            n = String.valueOf(num);

        for (int i = n.length() - 1; i >= 0; i--)
            reverse = reverse + n.charAt(i);

        try {
            if (num < 0)
                return Integer.valueOf(reverse) * -1;
            else
                return Integer.valueOf(reverse);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    private static int firstMissingPositive(int[] A) {

        if (A == null || A.length == 0) return 1;

        Arrays.sort(A);
        System.out.println(Arrays.toString(A));

        int x = 0;

        for (int i : A) {
            if (i < 0)
                x = 1;
            else if (i == x)
                x = i + 1;
            else if (i != 0)
                return x;
        }

        return x;
    }

    private static int lengthOfLastWord(final String A) {

        String[] arr = A.split(" ");
        int len = (arr.length) - 1;
        if (len > 0)
            return arr[len].length();
        else return 0;
    }

    private static int removeElement() {

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(15);
        a.add(3);
        a.add(9);
        a.add(3);
        a.add(3);
        int b = 3;

        int n = a.size();
        int i, j;

        for (i = 0, j = 0; j < n; j++) {
            if (a.get(j) != b) {
                a.set(i, a.get(j));
                i++;
            }
        }

        return i;

    }

    private static int removeElement(int[] a, int val) {
        int n = a.length;
        int i = 0, j = 0;
        while (i < n && a[i] == val) {
            i++;
        }

        for (; i < n; i++) {
            if (a[i] != val) {
                a[j] = a[i];
                j++;
            }

        }

        return j;
    }

    private static void validateAtoi() {
        System.out.println("main" + myAtoi("0-1"));
        System.out.println("main" + myAtoi("  +0 012e0"));
        System.out.println("main" + myAtoi("  +2 012e0"));
        System.out.println("main" + myAtoi("+-2"));
        System.out.println("main" + myAtoi("42"));
        System.out.println("main" + myAtoi("-91283472332 e"));
        System.out.println("main" + myAtoi("   -42"));
        System.out.println("main" + myAtoi("4193 with words"));
        System.out.println("main" + myAtoi("words and 987"));
        System.out.println("main" + myAtoi("   -115579378e25"));
        System.out.println("main" + myAtoi("-91283472332"));
    }

    private static int myAtoi(String str) {
        String num = "";
        char[] ch = str.toCharArray();
        boolean isOperator = false;
        boolean isNegative = false;
        boolean isNumFound = false;

        for (char c : ch) {
            if (c == ' ') {
                if (isOperator || isNumFound)
                    break;
            } else if (c == '-' || c == '+') {
                if (isNumFound || isOperator) break;
                isOperator = true;
                if (c == '-')
                    isNegative = true;

            } else if ((int) c >= 48 && (int) c <= 57) {
                isNumFound = true;

                num = num + c;
            } else {
                break;
            }
        }

        if (num.isEmpty()) return 0;
        num = isNegative ? "-1" + num : num;
        int n = Double.valueOf(num).intValue();
        return n;
    }

    private static void toLowerCase(String str) {

        if (str == null || str.isEmpty()) System.out.println(str);
        char[] ch = str.toCharArray();

        String res = "";

        for (char c : ch) {
            if (c >= 'A' && c <= 'Z') {
                c = (char) ((int) c + 32);
            }
            res = res + c;
        }

        System.out.println(res);
    }

    private static void hammingDistance(int x, int y) {
        int n = x ^ y;

        int count = 0;
        while (n > 0) {
            n &= n - 1;
            count++;
        }

        System.out.println("Hamming distance between " + x + " & " + y + " is :" + count);
    }

    private static int uniqueMorseRepresentations(String[] words) {

        if (words == null || words.length == 0) return 0;
        if (words.length == 1) return 1;

        String[] codes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        HashSet<String> set = new HashSet<>();

        for (String w : words) {
            int l = w.length();
            String code = "";
            for (char c : w.toCharArray()) {
                code = code + codes[(int) c - 97];
            }

            set.add(code);
        }

        return set.size();
    }

    private static void sortArrayByParity(int[] A) {
        Arrays.sort(A);
        Integer[] B = new Integer[A.length];
        for (int t = 0; t < A.length; ++t)
            B[t] = A[t];

        Arrays.sort(B, (a, b) -> Integer.compare(a % 2, b % 2));

        for (int t = 0; t < A.length; ++t)
            A[t] = B[t];

        System.out.println("sortArrayByParity " + Arrays.toString(A));
    }

    private static String longestCommonPrefixUsingSorting(String[] strs) {

        if (strs == null) return "";
        int l = strs.length;

        if (l == 0) return "";
        if (l == 1) return strs[0];
        if (strs[0].length() == 0) return "";

        String result = "";

        Arrays.sort(strs);
        String s1 = strs[0], s2 = strs[l - 1];
        int n1 = s1.length(), n2 = s2.length();

        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                result = result + s1.charAt(i);
                i++;
                j++;
            } else
                break;
        }

        return result;
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null) return "";
        int l = strs.length;

        if (l == 0) return "";
        if (l == 1) return strs[0];
        if (strs[0].length() == 0) return "";

        String result = "";

        int i = 0;
        char c = strs[0].charAt(0);
        boolean flag = true;
        while (flag) {
            for (String s : strs) {
                if (s.length() < i || s.charAt(i) != c) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result = result + c;
                i++;
                if (strs[0].length() > i) {
                    c = strs[0].charAt(i);
                } else
                    break;
            }
        }

        return result;
    }

    private static List<List<Integer>> threeSum(int[] A) {
        List<List<Integer>> lists = new ArrayList<>();
        int l = A.length;
        for (int i = 0; i < l - 2; i++) {

            HashSet<Integer> s = new HashSet<>();
            int curr_sum = 0 - A[i];

            for (int j = i + 1; j < l; j++) {

                if (s.contains(curr_sum - A[j]) && curr_sum - A[j] != (int) s.toArray()[s.size() - 1]) {
                    System.out.printf("Triplet is %d, %d, %d", A[i],
                            A[j], curr_sum - A[j]);
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(A[i]);
                    list.add(A[j]);
                    list.add(curr_sum - A[j]);
                    lists.add(list);
                }
                s.add(A[j]);
            }
        }

        return lists;
    }

    public static void main(String[] args) {

        /*System.out.println("Pascal's Traingle");
        pascalTraingle();

        System.out.println("Print Pascal's value :");
        getPascalValue(6, 3);

        System.out.println(" Get First Non Repeated Char In String ");
        getFirstNonRepeatedCharInString();

        System.out.println("Find Subarray for sum");
        findSubArrayForSum();

        System.out.println("Unmodifiable Collection");
        unmodifiableCollection();

        System.out.println("Longest Substring length");
        lengthOfLongestSubstring();

        System.out.println("Median of sorted array" + findMedianSortedArrays());

        System.out.println("Longest Palindrome String " + longestPalSubstr("abacababbaba"));

        System.out.println("Reversing integer" + revInteger(651));

        System.out.println("Convert Encoding " + convert("geeksforgeeks", 4));

        System.out.println("Missing positive" + firstMissingPositive(new int[]{21, 9, 6, 8, 4, -1, -8, 13, 1, 2, 5, 7, 19, 3}));

        System.out.println("length Of Last Word" + lengthOfLastWord("My name is Swati Rastogi"));

        System.out.println(" Remove element from array list : " + removeElement());

        System.out.println(" Remove element from an array : " + removeElement(new int[]{1, 2, 3, 3, 5, 6, 4, 3, 3}, 3));

        System.out.println("My ATOI ");
        validateAtoi();

        System.out.println("toLowerCase");
        toLowerCase("ABcdEFG");

        hammingDistance(9, 14); // 8 4 2 1 --- 1001 1110

        System.out.println("Unique morse code words : " + uniqueMorseRepresentations(new String[]{"gin", "zen"}));

        sortArrayByParity(new int[]{1});

        System.out.println(" Longest Common Prefix :  " + longestCommonPrefix(new String[]{"fabulous", "fairy", "far"}));

        System.out.println(" Longest Common Prefix :  " + longestCommonPrefixUsingSorting(new String[]{"fabulous", "fairy", "far"}));

        System.out.println("Reverse pairs count " + reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));

        System.out.println(" Longest consecutive sequence " + consecutiveSequence(new int[]{3, 1000, 1, 999, 2, 800, 5, 10, 4}));

        System.out.println("Convert to String " + convertIntToString(1234));

        System.out.println("Print num in words\n" + numToWords(7121988));
        System.out.println("Print num in words\n" + writeNumInWords(7121988));*/

        System.out.println("ExampleUnitTest.main : " + isValid("()()()"));
        System.out.println("ExampleUnitTest.main : " + isValid(""));
        System.out.println("ExampleUnitTest.main : " + isValid("()()("));
        System.out.println("ExampleUnitTest.main : " + isValid("()()(]"));
        System.out.println("ExampleUnitTest.main : " + isValid("()({)}"));
        System.out.println("ExampleUnitTest.main : " + isValid("[())"));
    }

    private static int reversePairs(int[] A) {
        if (A == null || A.length <= 1) return 0;
        int n = A.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = A[i];
                double b = 2 * A[j];
                if (A[i] > A[j] && A[i] > (A[j] * 2L))
                    count++;
            }
        }

        return count;
    }

    private static int consecutiveSequence(int[] a) {
        if (a == null || a.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int x : a) set.add(x);


        int maxLen = 0;

        for (int x : a) {
            if (!set.contains(x - 1)) {
                int currNum = x;
                int len = 1;

                while (set.contains(currNum + 1)) {
                    currNum++;
                    len++;
                }

                maxLen = len > maxLen ? len : maxLen;
            }
        }

        return maxLen;
    }

    private static String convertIntToString(int num) {

        String s = "";
        while (num > 0) {
            int n = num % 10 + '0';
            char c = (char) n;
            s = c + s;
            num = num / 10;
        }

        return s;
    }

    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen"};

    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    private static String numToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String s = "";

        while (num > 0) {
            if (num % 1000 != 0)
                s = numHelper(num % 1000) + THOUSANDS[i] + " " + s;
            num /= 1000;
            i++;
        }


        return s;
    }

    private static String numHelper(int num) {
        if (num == 0) return "";
        else if (num < 20) return LESS_THAN_20[num] + " ";
        else if (num < 100) return TENS[num / 10] + " " + numHelper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + numHelper(num % 100);
    }

    private static String writeNumInWords(int num) {
        if (num == 0) return "ZER0";

        String words = "";
        int i = 0;

        while (num > 0) {
            if (num % 1000 > 0) {
                words = helper(num % 1000) + " " + THOUSANDS[i] + " " + words;
            }
            num = num / 1000;
            i++;
        }

        return words;
    }

    private static String helper(int num) {
        if (num == 0) return "";
        else if (num < 20) return LESS_THAN_20[num];
        else if (num < 100) return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }

    private static boolean isValid(String s) {
        if(s == null || s.isEmpty()) return true;

        Stack<Character> st = new Stack<>();

        int i = 0;

        while(i < s.length()) {
            char c = s.charAt(i);
            if(c == '{' || c == '(' || c == '[')
                st.push(c);
            else if(!st.isEmpty()){
                char ch = st.peek();
                if(c == '}' && ch == '{'
                        || c == ']' && ch == '['
                        || c == ')' && ch == '(')
                    st.pop();

                else
                    return false;
            } else
                return false;

            i++;

        }

        return st.isEmpty();
    }
}