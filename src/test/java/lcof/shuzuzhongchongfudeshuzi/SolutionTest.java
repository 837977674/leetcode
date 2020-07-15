package lcof.shuzuzhongchongfudeshuzi;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findRepeatNumber() {
        assertEquals(2, new Solution().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}