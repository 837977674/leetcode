package xofakindinadeckofcards;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void hasGroupsSizeX() {
        new Solution().hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1});
    }
}