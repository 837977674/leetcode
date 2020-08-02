package shortestdistancetoacharacter;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void shortestToChar() {
        int[] arr = new Solution().shortestToChar("loveleetcode", 'e');
        for(int i : arr) {
            System.out.println(i);
        }
    }
}