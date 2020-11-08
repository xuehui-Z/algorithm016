// 桶排序原理
// 按照数组2的顺序收集桶中的元素，排序
// 再将数组2中不存在的元素进行排序

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int n : arr1) cnt[n]++;
        int i = 0;
        for (int n : arr2) {
            while (cnt[n]-- > 0) arr1[i++] = n;
        }
        for (int n=0; n<1001;n++) {
            while (cnt[n]-- > 0) arr1[i++] = n;
        }
        return arr1;
    }
}