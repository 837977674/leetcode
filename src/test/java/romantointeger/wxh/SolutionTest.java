package romantointeger.wxh;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void romanToInt() {
        String l="III";
        int k=new romantointeger.wxh.Solution().romanToInt(l);
        System.out.println(k);
    }
}
