package binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void search() {
        System.out.println(new Solution().search(new int[]{-1, 0, 3, 5, 9, 12}, 4));
    }
}