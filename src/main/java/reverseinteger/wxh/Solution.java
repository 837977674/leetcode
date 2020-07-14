package reverseinteger.wxh;

public class Solution {
    public int reverse(int x)
    {
        int sum=0;
        int k=0;

            while (Math.abs(x)>0)
            {
                sum = sum * 10 + x % 10;
                x/=10;
                if(x!=0 &&(sum>214748364||sum<-214748364))
                {return 0;}
            }
            return sum;

    }
}
