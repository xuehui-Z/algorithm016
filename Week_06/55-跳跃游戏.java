/**
思路
最先到达终点的步数

*/
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxStep = 0;
        for (int i=0; i<len; i++) {
            if (i <= maxStep) {
                maxStep = Math.max(maxStep,i + nums[i]);
                if (maxStep >= len - 1) {
                    return true;
                }
        }
        }
        return false;
    }
}