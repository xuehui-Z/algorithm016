//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 913 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
        vis = new boolean[nums.length];
        triverBack(nums,0);
        return ans;
    }

    public void triverBack(int[] nums,int index) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if(vis[i]) continue;
            temp.add(nums[i]);
            vis[i] = true;
            triverBack(nums,index+1);
            vis[i] = false;
            temp.remove(index);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
