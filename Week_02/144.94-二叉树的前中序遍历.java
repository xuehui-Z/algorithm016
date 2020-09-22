/*
	前序遍历
	递归遍历  根-左-右
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        inorder(root,resList);
        return resList;
    }

    private void inorder(TreeNode root,List<Integer> resList) {
        if (root == null) return;
		resList.add(root.val);
        inorder(root.left,resList);        
        inorder(root.right,resList);

    }
}
/*
	前序遍历
	利用栈，将需要遍历的节点按顺序压入栈中，判断栈非空，遍历节点（出栈），并将子节点按顺序压入栈中。
*/
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> stc = new LinkedList<>();
        while (root != null || !stc.isEmpty()) {
            while (root != null) {
                resList.add(root.val);
                stc.push(root);
                root = root.left;
            }
            root = stc.pop();
            
            root = root.right;
        }
        return resList;   
    }
}
/*
	中序遍历
	递归遍历  左-根-右
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        inorder(root,resList);
        return resList;
    }

    private void inorder(TreeNode root,List<Integer> resList) {
        if (root == null) return;
        inorder(root.left,resList);
        resList.add(root.val);
        inorder(root.right,resList);

    }
}
/*
	中序遍历
	利用栈，将需要遍历的节点按顺序压入栈中，判断栈非空，遍历节点（出栈），并将子节点按顺序压入栈中。
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> stc = new LinkedList<>();
        while (root != null || !stc.isEmpty()) {
            while (root != null) {
                stc.push(root);
                root = root.left;
            }
            root = stc.pop();
            resList.add(root.val);
            root = root.right;
        }
        return resList;
    }
}
