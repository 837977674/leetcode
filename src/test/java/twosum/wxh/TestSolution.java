package twosum.wxh;


import org.junit.Test;

import org.junit.Assert;


public class TestSolution {
    @Test
    public void testAdd() {
        int[] input = new int[]{3,2,4};
        int[] myRes = new twosum.wxh.Solution().twoSum(input, 6);
        int[] res = new int[]{1, 2};
        Assert.assertArrayEquals(myRes, res);
    }
}
