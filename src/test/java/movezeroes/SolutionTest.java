package movezeroes;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void moveZeroes() {
        int[] arr = new int[]{0,0,1};
        new Solution().moveZeroes(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}