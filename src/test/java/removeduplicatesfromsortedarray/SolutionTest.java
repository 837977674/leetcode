package removeduplicatesfromsortedarray;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void removeDuplicates() {
        int[] arr = new int[]{1, 1, 1};
        System.out.println(new Solution().removeDuplicates(arr));
        for (int i : arr) {
            System.out.println(i);
        }
    }
}