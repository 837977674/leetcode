package romantointeger.ztp;

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        HashMap<Character, Integer> specialMap = new HashMap<>();
        specialMap.put('I', 1);
        specialMap.put('X', 10);
        specialMap.put('C', 100);
        
        int res = 0;
        
        char[] cArr = s.toCharArray();

        for (int i = 0; i < cArr.length; i++) {
            if (specialMap.containsKey(cArr[i]) && i + 1 < cArr.length) {
                switch (cArr[i]) {
                    case 'I':
                        if (cArr[i+1] == 'V') {
                            res += 4;
                            i++;
                            continue;
                        } else if (cArr[i+1] == 'X') {
                            res += 9;
                            i++;
                            continue;
                        }
                        break;
                    case 'X':
                        if (cArr[i+1] == 'L') {
                            res += 40;
                            i++;
                            continue;
                        } else if (cArr[i+1] == 'C') {
                            res += 90;
                            i++;
                            continue;
                        }
                        break;
                    case 'C':
                        if (cArr[i+1] == 'D') {
                            res += 400;
                            i++;
                            continue;
                        } else if (cArr[i+1] == 'M') {
                            res += 900;
                            i++;
                            continue;
                        }
                        break;
                }
            }
            res += hashMap.get(cArr[i]);
        }
        
        return res;
    }
    
    
}