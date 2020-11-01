class Solution {
    private boolean[][] row = new boolean[9][9];
    private boolean[][] cel = new boolean[9][9];
    private boolean[][][] box = new boolean[3][3][9];
    private boolean valied = false;
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i,j});
                } else {
                    int digit = board[i][j] - '0' -1;
                    row[i][digit] = cel[j][digit] = box[i/3][j/3][digit] = true;
                }
            }
        }
        dfs(board,0);
    }

    private void dfs(char[][] board,int pos) {
        if (pos == spaces.size()) {
            valied = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0],j = space[1];
        for (int digit=0; !valied && digit<9;++digit) {
            if (!row[i][digit] && ! cel[j][digit] && !box[i/3][j/3][digit]) {
                row[i][digit] = cel[j][digit] = box[i/3][j/3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board,pos+1);
                row[i][digit] = cel[j][digit] = box[i/3][j/3][digit] = false;
            }
        }
    }
}
