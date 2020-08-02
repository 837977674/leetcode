package validpalindrome;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isPalindrome() {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a ecar"));
        System.out.println(new Solution().isPalindrome("r"));
        System.out.println(new Solution().isPalindrome(",.a/ba"));
        System.out.println(new Solution().isPalindrome(".,"));
    }
}