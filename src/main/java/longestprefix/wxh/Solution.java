package longestprefix.wxh;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";

        String a=strs[0];
        char[] b=a.toCharArray();
        int i=0;
        String c = "";
        String d="";
        while (i<b.length)
        {
            c=c.concat(String.valueOf(b[i]));
            int j=0;
            while(j<strs.length)
            {
                if (strs[j].startsWith(c))
                {j++;}
                else return d;
            }
            i++;
            d=c;
        }
        return d;

    }
}
