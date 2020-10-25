/**
	递归：深度优先算法
*/
    class Solution {
        int minChange = Integer.MAX_VALUE;
        public int minMutation(String start, String end, String[] bank) {
            char[][] banks = new char[bank.length][8];
            for (int i=0;i<bank.length;i++) {
                banks[i] = bank[i].toCharArray();
            }
            dfs(start.toCharArray(),end.toCharArray(),banks,0);
            return minChange==Integer.MAX_VALUE ? -1 : minChange;
        }
    
        public void dfs(char[] start,char[] end,char[][] banks,int change) {
            if (Arrays.equals(start,end)) {
                minChange = Math.min(minChange,change);
                return;
            }
    
            for (int i=0;i< banks.length;i++) {
                if (banks[i] == null) continue;
                char[] curBank = banks[i];
                int diff = 0;
                for (int j=0;j<start.length;j++) {
                    if (start[j] != curBank[j]) diff++;
                }
    
                if (diff == 1) {
                    banks[i] = null;
                    dfs(curBank,end,banks,change+1);
                    banks[i] = curBank;
                }
            }
        }
    }

/**
	广度优先算法
	更快的找到最短路径
*/

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> bank_library = new HashSet<>();
        for (String library : bank) {
            bank_library.add(library);
        }
        char[] banks = {'A', 'C', 'G', 'T'};
        LinkedList<String> dequeue = new LinkedList<>();
        dequeue.offer(start);
        int count = 0;
        HashSet<String> visited = new HashSet<>();
        while (!dequeue.isEmpty()) {
            int size = dequeue.size();
            while (size-- > 0) {
                String poll = dequeue.poll();
                if (poll.equals(end)) return count;
                char[] curr = poll.toCharArray();
                for (int i = 0; i < curr.length; i++) {
                    char old = curr[i];
                    for (char b : banks) {
                        curr[i] = b;
                        String newString = new String(curr);
                        if (!visited.contains(newString) && bank_library.contains(newString)) {
                            visited.add(newString);
                            dequeue.offer(newString);
                        }
                    }
                    curr[i] = old;
                }
            }
            count++;
        }
        return -1;
    }


