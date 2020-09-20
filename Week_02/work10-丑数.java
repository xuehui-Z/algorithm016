/*
	根据丑数的定义：我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）
	第一个丑数是1，第2个是1*2，第3个是1*3，第4个是1*5，下一个是前一个丑数*(2,3,5)中最小的一个
	
	解题思路：使用a,b,c三个下标代表第几个丑数，然后分别*2，3，5，取最小的，并且最小的数的下标前移
*/
class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int a=0,b=0,c=0;
        for (int i=1; i<n; i++) {
            int na = uglyNumbers[a] * 2;
            int nb = uglyNumbers[b] * 3;
            int nc = uglyNumbers[c] * 5;
            uglyNumbers[i] = Math.min(Math.min(na,nb),nc);
            if (uglyNumbers[i] == na) a++;
            if (uglyNumbers[i] == nb) b++;
            if (uglyNumbers[i] == nc) c++;
        }
        return uglyNumbers[n-1];
    }
}
