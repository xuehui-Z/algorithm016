/*
	1.利用HashMap将元素作为Key保存，出现次数作为Value保存。
	2.遍历HashMap，根据其Value值的大小保存到优先队列中。
	3.取队列中前K个元素
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n,map.getOrDefault(n,0)+1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            queue.offer(new int[] {num,count});
        }

        int[] res = new int[k];
        for (int i = 0;i<k;++i) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}