package climbingstairs.ztp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void climbStairs() {
        assertEquals(3, new Solution().climbStairs(3));
    }
}