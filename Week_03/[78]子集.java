//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 794 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int mark=0; mark < (1 << n); mark++) {
            List<Integer> temp = new ArrayList<>();
            for (int i=0;i<n;i++) {
                if ((mark & (1<<i))!=0) temp.add(nums[i]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
