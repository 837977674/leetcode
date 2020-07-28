package climbingstairs.ztp;

class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        int res = 0;
        if (n == 1) {
            return a;
        } else if (n == 2) {
            return b;
        }
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
