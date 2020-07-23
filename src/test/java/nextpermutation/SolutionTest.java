package nextpermutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void nextPermutation() {
        int[] arr = new int[]{1, 2, 3};
        new Solution().nextPermutation(arr);
        assertArrayEquals(new int[]{1, 3, 2}, arr);
    }
}