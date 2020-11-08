// 传统BFS方法
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words);
        for (String word:words) {
            if (exist(board,word)) result.add(word);
        }
        return result;
    }
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] useUtil = new boolean[h][w];
        for (int i=0; i<h; i++) {
            for (int j=0;j<w;j++) {
                boolean flg = check(board,useUtil,i,j,word,0);
                if (flg) return true;
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) return false;
        else if (k==s.length()-1) return true;
        visited[i][j] = true;
        int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean result = false;
        for (int[] dir : direct) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi>=0 && newi<board.length && newj>=0 && newj<board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flg = check(board,visited,newi,newj,s,k+1);
                    if (flg) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}

//使用前缀树
class Solution {
    private Set<String> result = new HashSet<>();
    int m;
    int n;
    public List<String> findWords(char[][] board, String[] words) {
        m=board.length;
        n=board[0].length;
        Trie trie = new Trie();
        for (String word:words) {
            trie.insert(word);
        }
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                dfs(trie,"",board,i,j,visited);
            }
        }
        return new ArrayList<>(result);
    }
    public void dfs(Trie trie, String str,char[][] board,int i,int j,boolean[][] visited) {
        if (i<0 || j<0 || i> m-1 || j > n-1 || visited[i][j]) return;
        str = str + String.valueOf(board[i][j]);
        if (!trie.startsWith(str)) return;
        if (trie.search(str)) {
            result.add(str);
        }
        visited[i][j] = true;
        dfs(trie,str,board,i+1,j,visited);
        dfs(trie,str,board,i-1,j,visited);
        dfs(trie,str,board,i,j+1,visited);
        dfs(trie,str,board,i,j-1,visited);
        visited[i][j] = false;
        str = str.substring(0,str.length()-1);
    }
}
//前面写的前缀树
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}