package decodeways.ztp;

import java.util.HashSet;


// 动态规划，没做出来
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 1) {
            return 1;
        }
        
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 1; i <= 26 ; i++) {
            hashSet.add(String.valueOf(i));
        }
        
        int res = 1;
        char[] cArr = s.toCharArray();
        for (int i = 1; i < cArr.length; i++) {
            String s1 = String.valueOf(new char[]{cArr[i-1], cArr[i]});
            if (hashSet.contains(s1)) {
                res++;
            }
            res++;
        }
        
        return res;
    }
}
