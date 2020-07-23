package longestprefix.ztp;


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String longest = strs[0];
        for (int i = 1; i < strs.length; i++) {
            char[] t1 = longest.toCharArray();
            char[] t2 = strs[i].toCharArray();
            int e = Math.min(t1.length, t2.length);
            int j;
            for (j = 0; j < e; j++) {
                if (t1[j] != t2[j]) {
                    break;
                }
            }
            longest = longest.substring(0, j);
        }
        return longest;
    }
}
