package rotatearray;

public class Solution {
    public void rotate(int[] nums, int k) {
        int[] aux = new int[nums.length];
        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int targetIdx = i + k;
            if (targetIdx >= nums.length) {
                targetIdx %= nums.length;
            }

            aux[targetIdx] = nums[targetIdx];
            flag[targetIdx] = true;
            
            if (!flag[i]) {
                nums[targetIdx] = nums[i];
            } else {
                nums[targetIdx] = aux[i];
            }
        }
    }
}
