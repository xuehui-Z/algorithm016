// 第奇数个位置的数中1的个数为其前一个偶数+1
// 第偶数个位置的数中1的个数为/2的数1的个数
class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        for (int i=1; i<=num; i++) {
            if (i%2 == 1) ans[i] = ans[i-1] + 1;
            else ans[i] = ans[i/2];
        }
        return ans;
    }
}