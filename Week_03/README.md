# 学习笔记 第3周
### 知识总结
本周主要学习了递归算法，包括泛型递归和树的递归。因为树本身结构就是通过递归来实现的，所以关于树的题目通常也是递归来解。并且递归可以很好地解决存在重复性的问题。以及复杂的递归：分治和回溯。
- **泛型递归**  
  递归也可以理解成是一种循环，它是通过自己调用自己来实现循环的。为了避免无线递归调用，所以在方法体的开始要写好终止条件，一般的递归模板(感谢超哥的模板，真的很好用)：  
  ```java
  public void recur(int level, int param) { 
      // terminator 
      if (level > MAX_LEVEL) { 
        // process result 
        return; 
      }
      // process current logic 
      process(level, param); 
      // drill down 
      recur( level: level + 1, newParam); 
      // restore current status 
     
  }
 
  ```
- *参考题目*
  - 括号生成：https://leetcode-cn.com/problems/generate-parentheses/
  - 爬楼梯：https://leetcode-cn.com/problems/climbing-stairs/
  
- **分治&回溯**  
  分治和回溯是递归的高级体现，分治是指递归调用的时候，不再是单一的重复问题，而是多个子问题的合集。所以就涉及到多个处理分支。回溯是指当在某一层递归中发现解决不了问题，则返回到上一层重新走另一个分支，回溯算法其实就是自己试错的体现。
  
- *参考题目*
  - Pow(x, n)：https://leetcode-cn.com/problems/powx-n/
  - 子集：https://leetcode-cn.com/problems/subsets/
  - N 皇后：https://leetcode-cn.com/problems/n-queens/
  
### 总结
对于存在重复性问题的题目，判断其最近重复性，如果重复子问题只有一种，则蚕蛹泛型递归即可，如果子问题是多个，则采用分治；而如果要在重复问题中寻找最优解的这种问题，一般采用回溯和动态规划来解决。