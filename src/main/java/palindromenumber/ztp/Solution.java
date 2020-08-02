package palindromenumber.ztp;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int aux = 0;
        while (aux < x) {
            aux = (aux*10) + (x%10);
            x /= 10;
        }
        return aux == x || aux/10 == x;
    }
}