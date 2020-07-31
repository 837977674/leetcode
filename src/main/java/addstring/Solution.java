package addstring;

class Solution {
    public String addStrings(String num1, String num2) {
        int maxLen;
        if (num1.length() > num2.length()) {
            maxLen = num1.length();
        } else {
            maxLen = num2.length();
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        
        boolean flag = false;
        int i;
        for(i = 1; i <= maxLen; i++) {
            if (arr1.length-i < 0 || arr2.length-i < 0) {
                break;
            }
            int t = arr1[arr1.length-i] + arr2[arr2.length-i] - 96;
            if (flag) {
                t++;
            }
            if (t > 9) {
                t %= 10;
                flag = true;
            } else {
                flag = false;
            }
            arr1[arr1.length-i] = (char) (t + 48);
        }
        for (;i <= arr1.length; i++) {
            int t = arr1[arr1.length - i] - '0';
            if (flag) {
                t++;
                flag = false;
            }
            if (t > 9) {
                t %= 10;
                flag = true;
            }
            arr1[arr1.length - i] = (char)(t + 48);
        }
        if (flag) {
            return "1" + String.valueOf(arr1);
        }
        
        return String.valueOf(arr1);
    }
}