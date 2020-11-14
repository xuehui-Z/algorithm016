class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i=1; i<n; i++) {
            dp[i] = grid[0][i] + dp[i-1];
        } //初始化数组
        for (int i=1; i<m; i++) {
            dp[0] += grid[i][0];
            for (int j=1; j<n; j++) {
                dp[j] = Math.min(dp[j],dp[j-1]) + grid[i][j]; //上面或左面最小的值加上自己
            }
        }
        return dp[n-1];

    }
}