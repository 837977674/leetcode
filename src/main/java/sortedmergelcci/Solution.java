package sortedmergelcci;

public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) {
            return;
        }
        
        int i = Math.max(m - 1, 0);
        int j = Math.max(n - 1, 0);
        int cnt = m + n - 1;
        while (j >= 0) {
            if (i < m && A[i] > B[j]) {
                A[cnt--] = A[i];
                A[i] = Integer.MIN_VALUE;
                if (i > 0) {
                    i--;
                }
            } else {
                A[cnt--] = B[j];
                j--;
            }
        }
    }
}
