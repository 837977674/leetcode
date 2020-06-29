package validparentheses.ztp;

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

    @Test
    public void testIsValid() {
        assertTrue(new Solution().isPair('{', '}'));
        assertFalse(new Solution().isPair('{', ')'));
    }
}