package lcof.erweishuzudechazhao.ztp1;

public class Solution {
    boolean res = false;

    void dfs(int[][] matrix, int i, int j, int x, int y, int target) {
        if (matrix[i][j] == target) {
            res = true;
            return;
        }
        if (i + 1 < x && matrix[i][j] < target && !res) {
            dfs(matrix, i + 1, j, x, y, target);
        }
        if (j + 1 < y && matrix[i][j] < target && !res) {
            dfs(matrix, i, j + 1, x, y, target);
        }
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int x = matrix.length;
        if (x == 0) {
            return false;
        }
        int y = matrix[0].length;
        if (y == 0) {
            return false;
        }

        dfs(matrix, 0, 0, x, y, target);
        return res;
    }
}
