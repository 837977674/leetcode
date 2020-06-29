package validparentheses.ztp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }

        Set<Character> rightSymbol = new HashSet<>();
        rightSymbol.add('}');
        rightSymbol.add(']');
        rightSymbol.add(')');

        LinkedList<Character> list1 = new LinkedList<>(); // {
        LinkedList<Character> list2 = new LinkedList<>(); // [
        LinkedList<Character> list3 = new LinkedList<>(); // (

        LinkedList<Integer> lastChar = new LinkedList<>();

        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '{') {
                list1.add(charArr[i]);
                lastChar.add(i);
                continue;
            }
            if (charArr[i] == '[') {
                list2.add(charArr[i]);
                lastChar.add(i);
                continue;
            }
            if (charArr[i] == '(') {
                list3.add(charArr[i]);
                lastChar.add(i);
                continue;
            }
            if (lastChar.size() == 0) {
                return false;
            }
            if (isPair(charArr[lastChar.peekLast()], charArr[i])) {
                if (charArr[i] == '}') {
                    list1.pop();
                    lastChar.pollLast();
                }
                if (charArr[i] == ']') {
                    list2.pop();
                    lastChar.pollLast();
                }
                if (charArr[i] == ')') {
                    list3.pop();
                    lastChar.pollLast();
                }
            } else {
                if (!rightSymbol.contains(charArr[lastChar.peekLast()])) {
                    return false;
                }
            }
        }

        return list1.isEmpty() && list2.isEmpty() && list3.isEmpty();
    }

    public boolean isPair(Character lastChar, Character c) {
        return ('[' == lastChar && ']' == c) ||
                ('(' == lastChar && ')' == c) ||
                ('{' == lastChar && '}' == c);
    }
}