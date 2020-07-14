package romantointeger.wxh;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {

        Map<String,Integer> map1=new HashMap<>();
        map1.put("IV",4);
        map1.put("IX",9);
        map1.put("XL",40);
        map1.put("XC",90);
        map1.put("CD",400);
        map1.put("CM",900);

       // Map<Character,Integer> map=new HashMap<>();

        map1.put("I",1);
        map1.put("V",5);
        map1.put("X",10);
        map1.put("L",50);
        map1.put("C",100);
        map1.put("D",500);
        map1.put("M",1000);

        String a;
        int sum=0;
        for(int j=0;j<s.length();j++)
        {
            /*if(j==s.length())
            {
                j=j-1;
            }*/
            if(j<=s.length()-2 )
            {

                a = s.substring(j, j + 2);

                if(map1.containsKey(a))
                {
                    sum=sum+map1.get(a);
                    j=j+1;
                }
                else
                {
                    sum=sum+ map1.get(s.substring(j,j+1));
                }

            }
            else
            {
                sum=sum+map1.get(s.substring(j, j + 1));
            }

            /*if(j==s.length()-2)
            {
                sum=sum+map1.get(s.substring(s.length()-2));
            }*/

        }

        return sum;

    }
}
