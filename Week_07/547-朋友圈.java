//传统DFS
class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                count++;
                dfs(M,visited,i);
            }
        }
        return count;
    }

    public void dfs(int[][] M, boolean[] visited, int i) {
        for (int j=0; j<M.length; j++) {
            if (!visited[j] && M[i][j] == 1) {
                visited[j] = true;a
                dfs(M,visited,j);
            }
        }
    }
}

//并查集
class Solution {
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

    public  void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }
    public int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
}