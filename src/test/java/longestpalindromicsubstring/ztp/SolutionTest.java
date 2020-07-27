package longestpalindromicsubstring.ztp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void longestPalindrome() {
        assertEquals("aba", new Solution().longestPalindrome("babad"));
        assertEquals("bb", new Solution().longestPalindrome("cbbd"));
    }
}