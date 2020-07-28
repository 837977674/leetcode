package sortedmergelcci;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void merge() {
        int[] A = new int[]{1,2,3,0,0,0};
        int[] B = new int[]{2,5,6};
        new Solution().merge(
                A, 3,
                B, 3
        );
        // int[] A = new int[]{0, 0, 0};
        // int[] B = new int[]{-1, 1, 2};
        // new Solution().merge(
        //         A, 0,
        //         B, 3
        // );
        System.out.println();
    }
}