/*
	经典解法，利用Hash
	遍历数组的同时，将遍历过的数组保存到map中，如果当前遍历的值在map中有和目标值的差值，则结束。
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] aws = new int[2];
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(target-nums[i])) {
                aws[0] = map.get(target-nums[i]);
                aws[1] = i;
                return aws;
            }
            map.put(nums[i],i);
        }
        return aws;
    }
}
/*
	暴力求解，两次遍历判断是否等于目标值
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] asw = new int[2];
        for (int i=0;i<nums.length-1;i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (target == nums[i] + nums[j]) {
                    asw[0] = i;
                    asw[1] = j;
                    return asw;
                }
            }
        }
        return asw;

    }
}
