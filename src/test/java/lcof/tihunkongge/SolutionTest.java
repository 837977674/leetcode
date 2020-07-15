package lcof.tihunkongge;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void replaceSpace() {
        assertEquals(new Solution().replaceSpace("We are happy."), "We%20are%20happy.");
    }
}