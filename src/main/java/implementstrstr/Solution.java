package implementstrstr;

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        char[] a1 = haystack.toCharArray();
        char[] a2 = needle.toCharArray();
        
        int windowLen = needle.length();
        for (int i = 0; i < haystack.length() - windowLen + 1;) {
            if (haystack.substring(i, i + windowLen).equals(needle)) {
                return i;
            }
            int idx = -1;
            for (int k = 0; k < a2.length; k++) {
                if (i + windowLen < a1.length && a1[i + windowLen] == a2[k]) {
                    idx = k;
                }
            }
            if (idx < 0) {
                i += windowLen + 1;
            } else {
                i += (windowLen - idx);
            }
        }
        return -1;
    }
}
