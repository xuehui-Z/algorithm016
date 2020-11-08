// n & 1 若n最后一位是1，则为1，否则位0
// 循环32次，每次将n右移，将r左移

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r = 0;
        for (int i=0; i<32; i++) {
            r <<= 1;
            if ((n&1)==1) r++;
            n >>= 1; 
        }
        return r;
    }
}