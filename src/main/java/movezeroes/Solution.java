package movezeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCnt = 0;
        for (int i = 0; i < nums.length - zeroCnt;) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - zeroCnt - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - zeroCnt - 1] = 0;
                zeroCnt++;
            } else {
                i++;
            }
        }
    }
}
