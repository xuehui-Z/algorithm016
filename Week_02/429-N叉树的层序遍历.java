/*
	利用双端队列，每次取值从队列头取值，从队列为放值
	首先获取队列的size，作为一层的节点数，遍历前size个节点，把节点值放入结果集，把节点的子节点放入队列尾
	队列不为空则继续
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0;i<size;i++) {
                root = queue.removeFirst();
                temp.add(root.val);
                for (Node child : root.children) {
                    queue.addLast(child);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}