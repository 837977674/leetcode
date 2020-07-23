package threesum;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void threeSum() {
        // new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        // new Solution().threeSum(new int[]{0, 0, 0});
        // new Solution().threeSum(new int[]{1,2,-2,-1});
        new Solution().threeSum(new int[]{3,-2,1,0});
    }
}