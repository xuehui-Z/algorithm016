//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 170 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> anwser = new ArrayList<>();
    int maxCount = 0;
    int curCount = 0;
    int curValue = 0;
    public int[] findMode(TreeNode root) {
        modBrinary(root);

        int[] res = new int[anwser.size()];
        for(int i=0;i<anwser.size();i++) {
            res[i] = anwser.get(i);
        }

        return res;
    }
    public void modBrinary(TreeNode root) {
        if (root == null) return;

        modBrinary(root.left);

        if (root.val == curValue) {
            curCount++;
        } else {
            curValue = root.val;
            curCount = 1;
        }
        if (curCount == maxCount) {
            anwser.add(curValue);
        } else if (curCount > maxCount) {
            anwser.clear();
            anwser.add(curValue);
            maxCount = curCount;
        }
        modBrinary(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
