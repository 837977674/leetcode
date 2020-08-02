package reverseinteger.ztp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void reverse() {
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(Integer.MAX_VALUE));
        System.out.println(new Solution().reverse(Integer.MIN_VALUE));
        System.out.println(new Solution().reverse(Integer.MAX_VALUE/10));
        System.out.println(new Solution().reverse(Integer.MIN_VALUE/10));
        System.out.println(new Solution().reverse(1534236469));
    }
}