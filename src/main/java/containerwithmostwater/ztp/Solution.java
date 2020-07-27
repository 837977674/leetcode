package containerwithmostwater.ztp;

class Solution {
    public int maxArea(int[] height) {
        int s = 0, e = height.length-1;
        int area = 0;
        while (s < e) {
            int low = Math.min(height[s], height[e]);
            int tmp = low * (e - s);
            if (tmp > area) {
                area = tmp;
            }
            if (height[s] < height[e]) {
                s++;
            } else {
                e--;
            }
        }
        return area;
    }
}
