package longestsubstringwithoutrepeatingcharacters.ztp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lengthOfLongestSubstring() {
        assertEquals(3, new Solution().lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}