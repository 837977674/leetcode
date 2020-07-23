package longestprefix.ztp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void longestCommonPrefix() {
        assertEquals("fl", new Solution()
                .longestCommonPrefix(new String[]{"flower","flow","flight"})
        );
    }
}