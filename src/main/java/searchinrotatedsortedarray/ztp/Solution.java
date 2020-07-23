package searchinrotatedsortedarray.ztp;

import static java.util.Arrays.binarySearch;

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target? 0 : -1;
        }

        int start = 0;
        int end = nums.length - 1;

        int keyPoint = (start + end)/2;
        while (nums[start] > nums[keyPoint] || nums[keyPoint+1] > nums[end]) {
            if (nums[start] < nums[keyPoint]) {
                start = keyPoint+1;
            } else {
                end = keyPoint;
            }
            keyPoint = (start + end)/2;
        }
        int idx1 = binarySearch(nums, 0, keyPoint+1, target);
        int idx2 = binarySearch(nums, keyPoint+1, nums.length, target);
        return idx1 >= 0 || idx2 > 0 ? Math.max(idx1, idx2):-1;
    }
}
