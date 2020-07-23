package threesum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        for (int k = j + 1; k < nums.length; k++) {
                            if (k == j + 1 || nums[k] != nums[k - 1]) {
                                if (nums[i] + nums[j] + nums[k] == 0) {
                                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                                }
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}