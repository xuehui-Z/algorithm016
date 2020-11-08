/**
思路
使用maxPosition记录最远位置
使用position记录当前位置
maxPosition在每走一步的时候更新
当遍历当当前位置是，增加一步，到最远位置
知道遍历结束
*/
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