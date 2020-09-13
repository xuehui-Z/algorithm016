# 学习笔记 

## 第一周 

这一周的学习开启了我的算法之旅，每天刷题成了睡前必做的事情，希望这个习惯能一直坚持下去。  
 
**对于以后的一个规划就是**  
+ 每天下班后在LeetCode上完成一个新题，复习2-3个做过的
+ 周末或者其他假期再抽出半天时间集中训练和复习；

**本周收获**  
这周最大的收获是学会了双指针这种解题思路，很巧妙；还有就是对于队列和栈的使用。  
*训练题目:*  
+ 1.盛最多水的容器: https://leetcode-cn.com/problems/container-with-most-water/ 
+ 2.接雨水 https://leetcode.com/problems/trapping-rain-water/

**问题点**  
依然存在的问题是对于递归这个方法还不能熟练使用，当出现多次递归调用的时候，思路就容易乱掉。  
*训练题目:*  
+ 1.组合 https://leetcode-cn.com/problems/combinations 
+ 2.三数之和 https://leetcode-cn.com/problems/3sum/ 
+ 3.N皇后问题 https://leetcode-cn.com/problems/n-queens  

# 双指针算法总结  
### (持续完善中...)
**双指针算法主要针对于一维数组，其核心思想就是把for的两重循环，即复杂度为O(n^2)优化成O(n)。**  
下面以成水最多的容器这个题为例，详细理解双指针  
*题目：* 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。  
*说明：* 你不能倾斜容器，且 n 的值至少为 2。

**枚举求解：**  两层循环依次计算出每两条线之间的面积，取最大值。时间复杂度O(n^2).   
*代码：*    
```java
	public int maxArea(int[] a) {
		int max = 0;
		for (int i=0; i<a.length-1; i++) {
			for (int j=i+1; j<a.length; j++) {
				int area = (j-i) * Math.min(a[i],a[j]);
				max = Math.max(max,area);
			}
		}
		return max;
	}
```
**双指针求解：** 两个指针分别指向最左和最右的两条线，在一层循环中往中间收敛(夹逼算法，第一次听还是在大学，听过就忘记了)，如果中间的线更高，则移动。先左后右或者先右后左，最终两个指针相遇，即完成所有遍历。时间复杂度O(n).   
*代码：*    
```java
	public int maxArea(int[] a) {
		int max = 0;
		for (int i=0, j=a.length-1; i<j; ) {
			int minHeigth = a[i] < a[j] ? a[i++] : a[j--];
			int area = (j-i+1) * minHeigth;
			max = Math.max(max,area);
		}
		return max;
	}
```  
*博文后续持续更新 ：https://blog.csdn.net/weixin_45577053/article/details/108568564*  


	
## 目标：给自己一年左右的时间，准备好冲击自己心仪的一线互联网公司。 
	