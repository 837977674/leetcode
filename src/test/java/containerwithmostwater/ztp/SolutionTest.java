package containerwithmostwater.ztp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxArea() {
        assertEquals(49, new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}