package twosum.azl;

import org.junit.Assert;
import org.junit.Test;

public class TestSolution {
    @Test
    public void testAdd() {
        int[] input = new int[]{2, 7, 11, 15};
        int[] myRes = new Solution().twoSum(input, 9);
        int[] res = new int[]{0, 1};
        Assert.assertArrayEquals(myRes, res);
    }
}
