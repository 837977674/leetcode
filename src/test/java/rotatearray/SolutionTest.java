package rotatearray;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void rotate() {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        new Solution().rotate(arr, 8);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}