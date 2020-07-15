package lcof.tihunkongge;

class Solution {
    public String replaceSpace(String s) {
        char[] cArr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : cArr) {
            if (c == 32) {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}