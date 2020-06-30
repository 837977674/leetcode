package twosum;


import java.util.Arrays;

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int [] arr=new int[2];
        for (int i=0;i<nums.length-1;i++)
        {
            //int a=nums[i];
            for(int j=i+1;j<nums.length;j++)
            {
                if (nums[i]+nums[j]==target)
                {
                    arr[0]=i;arr[1]=j;
                    return arr;
                }

            }
        }
        return arr;

    }

}
public class WXH {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().twoSum(new int[]{3,2,4}, 6)));
    }
}
