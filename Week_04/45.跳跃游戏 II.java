class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int maxPosition = 0;
        int step = 0, position = 0;
        for (int i=0;i<len-1;i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == position) {
                position = maxPosition;
                step++;
            }
        }
        return step;
    }
}