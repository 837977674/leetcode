package validparentheses.wxh;


import java.util.Arrays;
import java.util.Stack;

class Solution {
    public boolean isValid(String s)
    {
        Stack stack=new Stack();
        int i=0;
        char arr[]=s.toCharArray();
        while(i<arr.length)
        {
            if(arr[i]=='(')
                stack.push(arr[i]);
             else if (arr[i]=='[')
                stack.push(arr[i]);
            else if (arr[i]=='{')
                stack.push(arr[i]);

            if(arr[i]==')')
            {
                if (!stack.isEmpty()) {
                    if(stack.peek().equals('('))
                        stack.pop();
                    else stack.push(arr[i]);
                }
                else  stack.push(arr[i]);
            }

            if(arr[i]==']')
            {
                if (!stack.isEmpty()) {
                    if(stack.peek().equals('['))
                        stack.pop();
                    else stack.push(arr[i]);
                }
                else  stack.push(arr[i]);
            }



            if(arr[i]=='}')
            {
                if (!stack.isEmpty()) {
                    if(stack.peek().equals('{'))
                        stack.pop();
                    else stack.push(arr[i]);
                }
                else  stack.push(arr[i]);
            }
            i++;

        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
