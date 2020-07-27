package longestpalindromicsubstring.ztp;

public class Solution {
    public String longestPalindrome(String s) {
        char[] crr = s.toCharArray();
        boolean[][] res = new boolean[2000][2000];
        int max = 0;
        String ans = "";
        // l 子串长度
        for (int l = 0; l < crr.length; l++) {
            // i 起始位置
            for (int i = 0; i < crr.length; i++) {
                // j 结束位置
                int j = i + l;
                if (j >= crr.length) {
                    continue;
                }
                if (l == 0) {
                    res[i][j] = true;
                } else if (l == 1) {
                    if (crr[i] == crr[j]) {
                        res[i][j] = true;
                    } else {
                        res[i][j] = false;
                    }
                }  else {
                    res[i][j] = res[i + 1][j - 1] && (crr[i] == crr[j]);
                }
                if (res[i][j] && l >= max) {
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }
}
