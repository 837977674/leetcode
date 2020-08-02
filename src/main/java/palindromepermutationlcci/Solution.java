package palindromepermutationlcci;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        List<Character> list = new LinkedList<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (list.contains(c)) {
                list.remove(new Character(c));
            } else {
                list.add(c);
            }
        }
        return list.size() <= 1;
    }
}
