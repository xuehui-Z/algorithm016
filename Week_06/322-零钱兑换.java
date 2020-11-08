
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0; //面值为0，需要0个硬币
        for (int i=1; i<=amount; i++) { //从面值为1开始推，直到面值为amount
            for (int j=0; j<coins.length; j++) {
                if (i >= coins[j]) {  //面值必须大于硬币值，不然无法兑换
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] < amount+1 ? dp[amount] : -1;
    }
}