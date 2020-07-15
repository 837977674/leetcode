package lcof.erweishuzudechazhao.ztp2;


public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = matrix.length, y = matrix[0].length;
        int i = 0, j = y - 1;

        while (i < x && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
