package palindromenumber.wxh;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        int b=x;
        int i=0;
        int a=0;
        while (x>0)
        {
            i=x%10;
            a=a*10+i;
            x=x/10;
        }
        if (a==b) return true;
        else return false;
    }
}
