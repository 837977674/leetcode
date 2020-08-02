package palindromenumber.ztp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isPalindrome() {
        System.out.println(new Solution().isPalindrome(2222));
        System.out.println(new Solution().isPalindrome(12321));
        System.out.println(new Solution().isPalindrome(1221));
        System.out.println(new Solution().isPalindrome(123221));
        System.out.println(new Solution().isPalindrome(12));
        System.out.println(new Solution().isPalindrome(10));
        System.out.println(new Solution().isPalindrome(1));
        System.out.println(new Solution().isPalindrome(0));
    }
}