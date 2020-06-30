package validparentheses.ztp2;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('{', 0);
        map.put('[', 0);
        map.put('(', 0);


        HashMap<Character, Integer> rightMap = new HashMap<>();
        rightMap.put('}', 0);
        rightMap.put(']', 0);
        rightMap.put(')', 0);

        LinkedList<Integer> lastChar = new LinkedList<>();

        char[] charArr = s.toCharArray();
        
        for (int i = 0; i < charArr.length; i++) {
            if (map.containsKey(charArr[i])) {
                map.put(charArr[i], map.get(charArr[i]) + 1);
                lastChar.add(i);
                continue;
            }
            if (lastChar.size() == 0) {
                return false;
            }
            if (isPair(charArr[lastChar.peekLast()], charArr[i])) {
                if (charArr[i] == '}') {
                    map.put('{', map.get('{') - 1);
                    lastChar.pollLast();
                } else if (charArr[i] == ']') {
                    map.put('[', map.get('[') - 1);
                    lastChar.pollLast();
                } else if (charArr[i] == ')') {
                    map.put('(', map.get('(') - 1);
                    lastChar.pollLast();
                }
            } else {
                if (!rightMap.containsKey(charArr[lastChar.peekLast()])) {
                    return false;
                }
            }
        }

        return map.get('{') == 0 && map.get('[') == 0 && map.get('(') == 0;
    }

    public boolean isPair(Character lastChar, Character c) {
        return ('[' == lastChar && ']' == c) ||
                ('(' == lastChar && ')' == c) ||
                ('{' == lastChar && '}' == c);
    }
}