/**
解题思路
转化问题点，变成求一个数组中是否存在一组元素等于总数组和的一半。
计算数组元素总和sum，计算数组最大值maxNum。如果sum不是偶数，直接返回false；
计算数组元素和的一半target，如果maxNum大于target，也不会存在两组能等于target的组，返回false；
然后构筑DP方程：即从数组第一个数开始，能不能使其组合出target。
1.第一个数一定能组合出0和其自身（）。
2.前两个数一定能组合出 在1的基础上的，第二个数自身和第二个数加第一个数
。。。
在代码实现的时候需要注意的是一定要从target开始，依次往前找。
*/

//代码

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        int sum = 0,maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum,num);
        }
        if (sum%2 != 0) return false;
        int target = sum / 2;
        if (maxNum > target) return false;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        dp[nums[0]] = true;
        for (int i=1; i<n; i++) {
            int num = nums[i];
            for (int j=target; j>=num; j--) { //从后往前（关键，不然会导致num的倍数也会为True）
                dp[j] |= dp[j-num]; //j==num的时候即自身为True，dp[0]为true，
            }
        }
        return dp[target];

    }
}

作者：xuehui-zhu
链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/dong-tai-gui-hua-qiu-jie-by-xuehui-zhu/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。