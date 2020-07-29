package xofakindinadeckofcards;

import java.util.HashMap;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : deck) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i)+1);
            } else {
                hashMap.put(i, 1);
            }
        }
        int a = -1;
        for (Integer i : hashMap.keySet()) {
            if (a == -1) {
                a = hashMap.get(i);
            } else {
                a = gcd(a, hashMap.get(i));
            }
        }
        return a >= 2;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
