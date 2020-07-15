package lcof.erweishuzudechazhao;

import lcof.erweishuzudechazhao.ztp2.Solution;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findNumberIn2DArray() {
        int[][] input = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24}
        };
        assertTrue(new Solution().findNumberIn2DArray(input, 5));
        assertFalse(new Solution().findNumberIn2DArray(input, 20));
        int [][] input2 = {
                {1, 4},
                {2, 5}
        };
        assertTrue(new Solution().findNumberIn2DArray(input2, 5));
    }
}