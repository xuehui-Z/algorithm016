/**
解题思路
原数组：
1 3 1
1 5 1
4 2 1
初始化DP方程 ↓，对应位置为到该位置的最小和。
1 4 5
2 * *
6 * *
然后补足数组中其他位置，方法就是选前一个后者上一个中最小值，再加上自己
1 4 5
2 (5+2=7) (5+1=6)
6 (6+2=8) (6+1=7)
最后一个位置即为最小和。

将dp方程再简化为一维数组，即
第一步：1 4 5 //直接初始化
第二步：2 7 6 //在第一步基础上判断自己和前一个数字
第二步：6 8 7 //重复操作
返回数组最后一个。

作者：xuehui-zhu
链接：https://leetcode-cn.com/problems/minimum-path-sum/solution/dong-tai-gui-hua-qiu-jie-by-xuehui-zhu-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

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