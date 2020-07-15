package lcof.shuzuzhongchongfudeshuzi;

import java.util.HashSet;

class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return 0;
    }
}