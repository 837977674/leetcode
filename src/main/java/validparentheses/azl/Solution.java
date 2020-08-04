package validparentheses.azl;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        HashMap<Character, Character> map = new HashMap<>();

        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        
        char[] charArr = s.toCharArray();
        
        for (char c : charArr) {
            if (map.containsKey(c)) {
                stack.add(c);
            } else {
                if (stack.size() == 0 || !map.containsKey(stack.peek())) {
                    return false;
                } else if (c == map.get(stack.peek())) {  
                    // 判断是否可以出栈，如果最后一个字符和当前配对则可以出栈
                    stack.pop();
                } else {  // 如果不配对，则入栈
                    stack.push(c);
                }
            }
        }
        
        return stack.size() == 0;
    }
}
