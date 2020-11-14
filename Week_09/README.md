#学习笔记 第九周
### 动态规划
- **定义DP方程**
  对于动态规划的题目，主要的思路就是找到DP方程。首先要将问题分解成子问题，通过子问题找到当前问题的解，直到找到整个问题的解。    
  例如：不同路径Ⅱ（https://leetcode-cn.com/problems/unique-paths-ii/）的DP方程就可以如下分解    
  - m×n的棋盘，定义m×n的dp数组，数组每个位置代表从起点到当前位置的路径和，所以dp[0][i]=1, dp[i][0] = 1;  
  - 其他位置则等于其前一个位置和上一个位置的和（可以从前一个，上一个位置过来，只有这两种途径）  
  - 因为会有障碍物的存在，如果存在障碍物，障碍物位置为0，也就是没有路。
  - 所以dp方程为：如果不是障碍物 f(i,j) = f(i-1,j) + f(i,j-1); 否则f(i,j)=0；
  ```java
    class Solution {
      public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         
          // 定义 dp 数组并初始化第 1 行和第 1 列。
          int m = obstacleGrid.length, n = obstacleGrid[0].length;
          int[][] dp = new int[m][n];
          for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
              dp[i][0] = 1;
          }
          for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
              dp[0][j] = 1;
          }
  
          // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
          for (int i = 1; i < m; i++) {
              for (int j = 1; j < n; j++) {
                  if (obstacleGrid[i][j] == 0) {
                      dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                  }
              }
          }
          return dp[m - 1][n - 1];
      }
  }
  ```
- **dp方程空间复杂度优化**
  因为每次计算当前位置的值使用到的只是前一个位置和上一个位置的值，所以可以将二维的dp方程进一步优化成一维的，即f(i,j) = f(i-1,j) + f(i,j)
  ```java
    class Solution {
      public int uniquePathsWithObstacles(int[][] obstacleGrid) {          
          // 定义 dp 数组并初始化第 1 行和第 1 列。
          int m = obstacleGrid.length, n = obstacleGrid[0].length;
          int[] dp = new int[m];
          Arrsys.fill(dp,1);
  
          for (int i = 1; i < m; i++) {
              for (int j = 1; j < n; j++) {
                  if (obstacleGrid[i][j] == 0) {
                      dp[i] = dp[i - 1] + dp[i];
                  }
              }
          }
          return dp[m - 1];
      }
  }
  ```

