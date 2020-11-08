
/**
* java自带实现方法
* Integer.bitCount(n);
*/
public static int bitCount(int i) {
    // HD, Figure 5-2
    i = i - ((i >>> 1) & 0x55555555);
    i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
    i = (i + (i >>> 4)) & 0x0f0f0f0f;
    i = i + (i >>> 8);
    i = i + (i >>> 16);
    return i & 0x3f;
}

/**
* 与运算 右移
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}

/**
* 比较全的解法：
* https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/solution/wei-yun-suan-he-pai-xu-kan-wan-ni-neng-xie-chu-sha/
*/

