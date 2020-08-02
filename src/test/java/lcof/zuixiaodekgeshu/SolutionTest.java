package lcof.zuixiaodekgeshu;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getLeastNumbers() {
        int[] arr = new int[]{5, 3, 6, 8, 9, 2};
        new Solution().getLeastNumbers(arr, 3);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}