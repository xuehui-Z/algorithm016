//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 329 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

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
    Map<Integer,Integer> hashUtil = new HashMap<>();
    int post = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        this.post = n - 1;
        for (int i=0;i<n;i++) {
            hashUtil.put(inorder[i],i);
        }
        return creatTree(inorder,postorder,0,n-1);
    }

    public TreeNode creatTree(int[] inorder,int[] postorder,int in_start,int in_end) {
        if (in_start > in_end) return null;

        int root_val = postorder[post];
        TreeNode root = new TreeNode(root_val);

        int in_index = hashUtil.get(root_val);

        post--;
        root.right = creatTree(inorder,postorder,in_index+1,in_end);
        root.left = creatTree(inorder,postorder,in_start,in_index-1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
