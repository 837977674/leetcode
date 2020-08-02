package validpalindrome;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        List<Integer> aux = new LinkedList<>();
        boolean found = false;
        while (start < end) {
            while (start < end && !isValid(arr[start])) {
                start++;
            }
            while (start < end && !isValid(arr[end])) {
                end--;
            }
            if ((!isValid(arr[start]) || !isValid(arr[end])) && !found) {
                return true;
            } else {
                found = true;
            }
            if (start <= end && !isEqual(arr[start], arr[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isValid(char c) {
        return  (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }
    private static boolean isEqual(char a, char b) {
        if (a >= 'a' && a <= 'z') {
            return (a-b) == 32 || a == b;
        } else if (a >= 'A' && a <= 'Z') {
            return (b-a) == 32 || a == b;
        } 
        return a == b;
    }
}
