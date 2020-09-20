/*
	递归遍历
	前序遍历：先看根节点，子节点从左到右的顺序
	
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        triverTree(root,ans);
        return ans;
    }

    private void triverTree(Node root,List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);  //先根节点
        for (Node child : root.children) {
            triverTree(child,ans);  //子节点从左到右
        }
    }
}