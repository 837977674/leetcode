package uglynumber.ztp;

public class Solution {
    boolean res = true;

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        } else if (num == 1) {
            return true;
        }
        fun(num);
        return res;
    }
    void fun(int num) {
        if (num % 2 == 0) {
            fun(num/2);
            return;
        }
        if (num % 3 == 0) {
            fun(num/3);
            return;
        }
        if (num % 5 == 0) {
            fun(num/5);
            return;
        }
        if (num == 1) {
            return;
        }
        res = false;
    }

}
