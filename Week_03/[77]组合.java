//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 398 👎 0


//解法1：运行时间 33 ms	内存消耗40.6 MB
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return ans;
    }

    public void dfs(int index,int n,int k) {
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        if (index > n) return;
        temp.add(index);
        dfs(index+1,n,k);
        temp.remove(temp.size()-1);
        dfs(index+1,n,k);
    }
}
//解法2：运行时间 2ms	内存消耗40.2 MB
class Solution {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return results;
    }
    private void dfs(int cur,int n,int k) {
        if (temp.size() + (n+1-cur) < k) return; //当数组剩余元素不足以构成新组合的时候，直接return，所以此解法比第一种快很多。
        if (temp.size() == k) {
            results.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(cur);
        dfs(cur+1,n,k);
        temp.remove(temp.size() - 1);
        dfs(cur+1,n,k);
    }
}
