//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 612 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<List<String>>();
        int[] state = new int[n];  //用来存放每一层中皇后的位置
        findQueens(resultList,0,n,state);
        return resultList;
    }
    private void findQueens(List<List<String>> resultList, int cur, int n, int[] state) {
        if(cur == n){ //最后一行安排了皇后，即产生一种新解法
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
                state[cur] = i;  //当前层的皇后放在第i个位置
                boolean flag = true; 
                for(int j=0;j< cur;j++){  //判断前面层中已经存在的皇后堆当前层皇后的影响
                    boolean bt = state[cur]==state[j]-(cur-j)||state[cur] == state[j]+(cur-j);  //斜线可以攻击
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
//leetcode submit region end(Prohibit modification and deletion)
