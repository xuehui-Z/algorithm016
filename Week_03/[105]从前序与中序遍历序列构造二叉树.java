//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 685 👎 0


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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length - 1;
        for (int i=0;i<=n;i++) {
            hashUtil.put(inorder[i],i);
        }
        return creatTree(inorder,preorder,0,n);
    }
    public TreeNode creatTree(int[] inorder,int[] preorder,int in_start,int in_end) {
        if (in_start > in_end) return null;

        int root_val = preorder[preIndex];
        TreeNode root = new TreeNode(root_val);

        int root_Index = hashUtil.get(root_val);

        preIndex++;
        root.left = creatTree(inorder,preorder,in_start,root_Index-1);
        root.right = creatTree(inorder,preorder,root_Index+1,in_end);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
