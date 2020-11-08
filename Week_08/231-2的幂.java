// 2的幂 二进制只有一个1
// 将其减一，则元1位置变成0，后面变成1
// 进行与运算为0

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0; 
    } 
}