package removeduplicatesfromsortedarray;

class Solution {
    public int removeDuplicates(int[] nums) {
        int j;
        int cnt = 0;
        for (int i = 0; i < nums.length; i = j) {
            nums[cnt++] = nums[i];
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    break;
                }
            }
        }
        return cnt;
    }
}