/**
	思路：
	遍历数组，判断每个元素的情况。使用贪心思想，尽可能先把10元的找出去，因为5元的可以当作是万能的，尽量多。
	实现：
	1.初始化，一开始5元和10元都是0张；
	2.遍历数组，如果是5元的，不用找，5元的加一张；
			如果是10元的，判断有没有5元的，有的话，5元的减一，10元的加一；否则就失败，返回false；
			如果是20元的，优先把10元的找出去。。。
			
*/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i=0;i<bills.length;i++) {
            if (bills[i] == 5) five++;
            else if (bills[i] == 10) {
                if (five>0) {
                    five--;
                    ten++;
                } else return false;
            } else {
                if (ten>0 && five>0) {
                    ten--;
                    five--;
                } else if (five>=3) {
                    five -= 3;
                } else return false;
            }
        }
        return true;

    }
}