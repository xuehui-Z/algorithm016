class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<9;i++) {
            Set<Character> rowUtil = new HashSet<>();
            Set<Character> celUtil = new HashSet<>();
            Set<Character> boxUtil = new HashSet<>();
            for (int j=0;j<9;j++) {
                int bi = (j / 3) + (i % 3) * 3;
                int bj = (j % 3) + (i / 3) * 3;
                if (board[i][j]!='.' && !rowUtil.add(board[i][j])) return false;
                if (board[j][i]!='.' && !celUtil.add(board[j][i])) return false;
                if (board[bi][bj]!='.' && !boxUtil.add(board[bi][bj])) return false;
            }
        }
        return true;
    }
}
