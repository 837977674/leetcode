package searchinrotatedsortedarray.ztp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void search() {
        assertEquals(2, new Solution().search(new int[]{3, 5, 1}, 1) );
        assertEquals(0, new Solution().search(new int[]{1}, 1) );
        assertEquals(5, new Solution().search(new int[]{3, 4, 5, 6, 7, 0, 1, 2}, 0) );
        assertEquals(4, new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) );
    }
}