class Solution {
    int row;
    int col;
    public int numIslands(char[][] grid) {
        row = grid.length;
        if (row == 0) return 0;
        col = grid[0].length;
        int ans = 0;
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    hander(grid,i,j);
                }
            }
        }
        return ans;
    }

    private void hander(char[][] grid,int i,int j) {
        if ( i<0 || j<0 || i>= row || j>= col || grid[i][j] == '0') return;
        grid[i][j] = '0';
        hander(grid,i+1,j);
        hander(grid,i-1,j);
        hander(grid,i,j+1);
        hander(grid,i,j-1);
    }
}