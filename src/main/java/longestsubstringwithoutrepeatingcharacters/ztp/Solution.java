package longestsubstringwithoutrepeatingcharacters.ztp;

import java.util.LinkedList;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] cArr= s.toCharArray();
        LinkedList<Character> hashSet = new LinkedList<>();
        int i = 0, j = 0;
        int res = 0;
        while (i <= j && j < cArr.length) {
            if (!hashSet.contains(cArr[j])) {
                hashSet.add(cArr[j]);
                j++;
                res = Math.max(res, hashSet.size());
            } else {
                while (hashSet.contains(cArr[j])) {
                    hashSet.removeFirst();
                    i++;
                }
            }
        }
        return res;
    }
}