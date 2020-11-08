/**
解题思路
通过比较前一家的最大值和当前家和前两家的最大值和取得当前家的最大值
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i=1; i<n; i++) {
            dp[i+1] = Math.max(dp[i],nums[i]+dp[i-1]);
        }
        return dp[n];
    }
}