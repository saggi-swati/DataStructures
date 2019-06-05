package ds.saggi.in.datastructures;

import org.junit.Test;

public class DynamicProgramming {

    @Test
    public void testLongestSubSequence() {
        String a = "AGGTAB";
        String b = "GXTXAYB";

        System.out.println("DynamicProgramming.testLongestSubSequence : " + leastCommonSubSeq(a.toCharArray(), b.toCharArray(), a.length(), b.length()));

    }

    private int leastCommonSubSeq(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m+1][n+1];

        for(int i = 1;i<=m;i++) {
            for(int j = 1;j<=n;j++) {
                if(i == 0 || j == 0) {
                    L[i][j] = 0;
                }

                if(X[i-1] == Y[j-1]) {
                    L[i][j] = L[i-1][j-1] + 1;
                } else {
                    L[i][j] = Math.max(L[i][j-1], L[i-1][j]);
                }
            }
        }

        return L[m][n];

    }
}
