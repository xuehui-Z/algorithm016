class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        int maxSun = Integer.MIN_VALUE;
        for (int l=0; l<col; ++l) {
            int[] dp = new int[row];
            for (int r=l; r<col; ++r) {
                for (int i=0; i<row; i++) {
                    dp[i] += matrix[i][r];
                }
                maxSun = Math.max(maxSun,getMax(dp,k));
                if (maxSun == k) return k;
            }
        }
        return maxSun;
    }
    private int getMax(int[] arr, int k) {
        int rollSum = arr[0], rollMax = rollSum;
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) rollSum += arr[i];
            else rollSum = arr[i];
            if (rollSum > rollMax) rollMax = rollSum;
        }
        if (rollMax <= k) return rollMax;
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) max = sum;
                if (max == k) return k; // 尽量提前
            }
        }
        return max;
    }

}