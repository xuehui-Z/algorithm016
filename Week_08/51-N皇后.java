//递归+回溯

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<List<String>>();
        int[] state = new int[n];
        findQueens(resultList,0,n,state);
        return resultList;
    }
    private void findQueens(List<List<String>> resultList, int cur, int n, int[] state) {
        if(cur == n){
            List<String> reslt = new ArrayList<>();
            for(int i=0;i< n;i++){
                StringBuilder temp = new StringBuilder();
                for(int j=0;j< state.length;j++){
                    if(j== state[i]) temp.append("Q");
                    else temp.append(".");
                }
                reslt.add(temp.toString());
            }
            resultList.add(reslt);
        } else {
            for(int i=0;i<n;i++){
                state[cur] = i;
                boolean flag = true;
                for(int j=0;j< cur;j++){
                    boolean bt = state[cur]==state[j]-(cur-j)||state[cur] == state[j]+(cur-j);
                    if(state[cur]==state[j] || bt ){
                        flag = false;
                        break;
                    }
                }
                if(flag) findQueens(resultList,cur+1,n,state);
            }
        }
    }
}

//基于位运算的实现

class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> solutions = new ArrayList<List<String>>();
        solve(solutions, queens, n, 0, 0, 0, 0);
        return solutions;
    }

    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                int column = Integer.bitCount(position - 1);
                queens[row] = column;
                solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                queens[row] = -1;
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。