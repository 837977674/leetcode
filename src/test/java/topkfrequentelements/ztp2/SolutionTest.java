package topkfrequentelements.ztp2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void topKFrequent() {
        assertArrayEquals(new int[]{3,1}, new Solution().topKFrequent(new int[]{1,1,1,2,2,3,3,3,3}, 2));
    }
}