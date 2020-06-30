package validparentheses.ztp2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isValid() {
        assertFalse(new Solution().isValid("{"));
        assertFalse(new Solution().isValid("{]"));
        assertFalse(new Solution().isValid("(])"));
        assertTrue(new Solution().isValid("{[]}"));
        assertFalse(new Solution().isValid("([)]"));
        assertTrue(new Solution().isValid("(([]){})"));
        assertFalse(new Solution().isValid("]]]["));
    }
}