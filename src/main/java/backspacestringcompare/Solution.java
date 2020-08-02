package backspacestringcompare;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuffer sb1 = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (c == '#' && sb1.length() > 0) {
                sb1.deleteCharAt(sb1.length()-1);
            } else if (c != '#') {
                sb1.append(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (c == '#' && sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length()-1);
            } else if (c != '#') {
                sb2.append(c);
            }
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab###c", "ad#c"));
        System.out.println(new Solution().backspaceCompare("a#c", "b"));
        System.out.println(new Solution().backspaceCompare("ab##", "b#d#"));
    }
}
