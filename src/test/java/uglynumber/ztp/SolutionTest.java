package uglynumber.ztp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isUgly() {
        assertTrue(new Solution().isUgly(6));
        assertFalse(new Solution().isUgly(14));
        assertTrue(new Solution().isUgly(2));
    }
}