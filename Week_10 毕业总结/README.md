# 算法训练营 毕业总结

## 70天学习复盘
70天真的不算长，转瞬即逝。当初怀抱着要进入大厂的心态报名了算法训练营。从9月初开始坚持每天刷LeetCode题目，到现在也刷了150多道题了，是算法训练营带我上了算法的车。现在养成习惯，不把LeetCode的每日一题完成，再做几道旧的题目，就感觉这一天任务没有完成。  
真的非常感谢超哥和助教老师以及班主任老师。这70天让我受益匪浅，走上了一条上升的道路，我自己应该坚持住。
- **第一周**学习了一些基本数据结构，这里面大部分数据结构都很熟悉，只是跳表这个数据结构以前没接触过，这种空间换时间，利用升维来优化时间复杂度的思想还是很新颖的，也很实用。虽说数据结构都清楚，但是接触到题目还是感觉无从下手，只能先看题解，可能是做的提太少了把，没有养成机械的记忆，看到某一类题目就知道要用什么方法解决的思维是训练出来的。  
- **第二周**学习的是一些高级的数据结构，像哈希表，以及树。这些数据结构之前多多少少也学习过，老师讲一遍基本就能想起来或者理解了。对于哈希表，在Java中HashMap的实现源码也看了一遍。  
- **第三周**讲了递归，分治，回溯。这三种思想是从大局观出发来解决问题的一种思维方式，将复杂问题分解成简单问题。如果复杂问题能分解成重复的子问题，那就直接递归调用求解子问题的方法即可。如果复杂问题分解成不同的子问题，那就根据条件进行不同分支的求解，也就是分而治之（分治），最终只需要把不同分支的结果汇总到一起即可。回溯可以理解成走到了死胡同，没办法只能往回走，也就是恢复到上一层的递归方法，它是解决一些不确定问题时进行试错处理的思想，即当沿着一条路往下走得不到正确解的时候，就进行回溯。  
- **第四周** 
  -  *深度优先和广度优先*算法，对于树状结构或者是图进行遍历的两种不同方式，各自有优缺点和使用场景。深度优先是沿着一条路往下走，直到走到终点；广度优先是看每一条路的路口，一层层往下探索，直至每条路的终点。使用广度优先可以更快的找到最短路径问题。  
  - *贪心算法*是一种理想情况下更高效的解决方法，通过找到子问题的最优解，来确定最终问题的最优解。比如找零问题，因为币额的设计就是为了满足贪心算法来设计的。
  - *二分查找*是针对有序的数组，能更快找到目标值的查找方式，不在从头到尾依次查找O(n),而是一分为二进行查找，所有时间复杂度优化到O(logn)。  
- **第五周**是期中考试周，通过期中考试，发现自己的不足，对于怎么求时间复杂度还不是很了解，看一些博客问题把这一块补一补。
- **第六周**讲的动态规划，这种思想可以说是算法中必备的一种思想，它通过保存求解过程中的一些中间结果，简化了时间复杂度，去除了重复子问题的求解。通过DP方程根据前面计算的结果推导出下一步的结果，进而得到最终解。
- **第七周**  
  - 字典树，字典树又叫前缀树（Trie），是处理字符串或者单词匹配问题的一种更方便的结构，它每个节点保存一个字符，就可以通过前缀确定出可能要输入的单词是什么。  
  - 并查集是解决组团，配对问题的一种有效数据结构，它通往上寻找判断两个节点能不能相交来判断是不是同一个团组。  
  - 高级搜索是在基本的搜索方式上尽可能的加快搜速速度，比如今早将不符合结果的分支终止掉--剪枝；从起始位置和终止位置双向开始，每次处理更简单的一端，直到两端相遇--双向BFS；根据实际问题确定优先度，再根据优先度进行搜索--启发式搜索。
  - 红黑树和AVL树是一种平衡树，是保证树的平衡，避免树的极端情况（所有节点都集中在一边，就退化成链表了）。
- **第八周**学习了位运算，以计算机的思维来处理一些问题，有时候会快很多。布隆过滤器和LRU缓存，进一步了解和缓存和高效识别的处理方法，计算机的内存读取速度快，但是内存优先，所以引入了缓存，以及缓存替换算法。为了能高效的判断元素是否存在，加一个布隆过滤器可以提高速度，布隆过滤器执行效率高，他判断不存在就一定不存在，就剩去了遍历元素的过程，提高查询效率。还学习了各种经典的排序算法，这些排序算法真的应该牢记。  
- **第九周**讲了高级动态规划和字符串处理问题。高级的动态规划难就难在要理解怎么保存中间值，通过升维来实现，也就意味着要理解更复杂的DP方程，所以这一块还是要多练习。对于字符串算法，Java和其他高级语言都封装好了，工作中只是拿来用就好了，但是其原理还是了解一下会更好。
- **第十周**期末考试，学习回顾。每天坚持刷题。

## 知识大纲
### 数据结构
- 数组：最基本，最简单的一种结构，查找和更新是O(1)时间复杂度，插入和删除是O(n)复杂度（如果是操作末尾元素则是O(1)）。
- 链表：由节点元素和下一个元素指针（如果是双向链表，还有上一个元素指针）构成，查找时间复杂度为O(n),插入删除操作时间复杂度为O(1)。
- 跳表：用的比较少，是在链表的基础上增加维度，将链表分为n个小块，记录范围，这样查找的话就可以先确定一块范围，再进一步查找。
- 栈：先进后出。
- 队列：先进先出。双端队列既可以先进先出，也可以后进先出。
- 优先队列：节点元素上增加优先值，优先值高的先出。
- 哈希表：数组＋链表（或者其他结构）实现，查找,插入和删除一般都为O(1)。通过哈希算法确定元素在数组的下标。
- 树：树是一种常见且非常灵活的数据结构，在树的基础上衍生出了各种各样的树。
  - 二叉搜索树： 二叉树的一种，左子树小于根，右子树大于根。因此二叉搜索树中序遍历是递增数组。
  - AVL树：通过平衡因子控制左子树和右子树的高度差。通过旋转操作进行平衡操作（左旋，右旋，左右旋，右左旋）：
  - 红黑树：红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一
个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树：
  1.每个结点要么是红色，要么是黑色
  2.根结点是黑色
  3.每个叶结点（NIL结点，空结点）是黑色的。
  4.不能有相邻接的两个红色结点
  5.从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。
  - 字典树（前缀树）：这就不再是二叉树了，它会有很多节点，保存单个字符，通过深度优先搜索确定一个单词。
- 堆：主要有大顶堆和小顶堆。
  
### 算法思想
- 递归：一个方法调用自己就是递归，递归能通过计算简单子问题来得到复杂问题的解，一个递归方法一般包含这四部分：递归终止条件；子问题求解过程；递归调用处理下一个子问题；状态恢复。
- 分治：递归的一种，对不同子问题进行不同分支处理，最后合并。
- 回溯：当问题得不到想要的解的时候，恢复到上一层状态。
- 深度优先搜索(DFS)：对于树状结构的一种遍历方法，通过递归或者手动维护一个栈来实现，从一个节点出发，遍历其一个子节点，一直往下，直到终点再遍历另一个子节点。
- 广度优先搜索(BFS)：通过维护一个队列，从一个节点出发，遍历其所有子节点，再依次遍历子节点的所有子节点。
- 双向BFS：从起始位置和终止位置双向开始，每次处理更简单的一端，直到两端相遇。
- 贪心算法：子问题的最优解可以得到最终问题的最优解，每次只要找子问题最优解即可。
- 二分法：将问题一分为二，先求其中一半问题的解，再合并两个子问题。
- 动态规划：通过数组或者变量记录子问题的解，当遇到重复的子问题时就免去了重复计算。定义好DP转移方程一步步得到最终解。
- 位运算：左移，右移，按位或，按位与，按位取反
  1. 将 x 最右边的 n 位清零：x & (~0 << n)
  2. 获取 x 的第 n 位值（0 或者 1）： (x >> n) & 1
  3. 获取 x 的第 n 位的幂值：x & (1 << n)
  4. 仅将第 n 位置为 1：x | (1 << n)
  5. 仅将第 n 位置为 0：x & (~ (1 << n))
  6. 将 x 最高位至第 n 位（含）清零：x & ((1 << n) - 1)  
  - 判断奇偶：  
    x % 2 == 1 —> (x & 1) == 1  
    x % 2 == 0 —> (x & 1) == 0  
  - x >> 1 —> x / 2.
    即： x = x / 2; —> x = x >> 1;
    mid = (left + right) / 2; —> mid = (left + right) >> 1;
  - X = X & (X-1) 清零最低位的 1
  - X & -X => 得到最低位的 1
  - X & ~X => 0
- 排序算法:  
  十大经典排序算法: https://www.cnblogs.com/onepixel/p/7674659.html
  9种经典排序算法可视化动画: https://www.bilibili.com/video/av25136272
  6分钟看完15种排序算法动画展示: https://www.bilibili.com/video/av63851336

### 代码模板
- 递归代码模板
  ```java
  // Java
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
- 分治代码模板
  ```java
  private static int divide_conquer(Problem problem, ) {
    
    if (problem == NULL) {
      int res = process_last_result();
      return res;     
    }
    subProblems = split_problem(problem)
    
    res0 = divide_conquer(subProblems[0])
    res1 = divide_conquer(subProblems[1])
    
    result = process_result(res0, res1);
    
    return result;
  }

  ```
- DFS
  ```java
  //Java
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> allResults = new ArrayList<>();
      if(root==null){
          return allResults;
      }
      travel(root,0,allResults);
      return allResults;
  }
  
  
  private void travel(TreeNode root,int level,List<List<Integer>> results){
      if(results.size()==level){
          results.add(new ArrayList<>());
      }
      results.get(level).add(root.val);
      if(root.left!=null){
          travel(root.left,level+1,results);
      }
      if(root.right!=null){
          travel(root.right,level+1,results);
      }
  }
  ```
- BFS
  ```java
  //Java
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
  
      TreeNode(int x) {
          val = x;
      }
  }
  
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> allResults = new ArrayList<>();
      if (root == null) {
          return allResults;
      }
      Queue<TreeNode> nodes = new LinkedList<>();
      nodes.add(root);
      while (!nodes.isEmpty()) {
          int size = nodes.size();
          List<Integer> results = new ArrayList<>();
          for (int i = 0; i < size; i++) {
              TreeNode node = nodes.poll();
              results.add(node.val);
              if (node.left != null) {
                  nodes.add(node.left);
              }
              if (node.right != null) {
                  nodes.add(node.right);
              }
          }
          allResults.add(results);
      }
      return allResults;
  }
  ```
- 二分查找
  ```java
  // Java
  public int binarySearch(int[] array, int target) {
      int left = 0, right = array.length - 1, mid;
      while (left <= right) {
          mid = (right - left) / 2 + left;
  
          if (array[mid] == target) {
              return mid;
          } else if (array[mid] > target) {
              right = mid - 1;
          } else {
              left = mid + 1;
          }
      }
  
      return -1;
  }
  ```
- 前缀树
  ```java
  //Java
  class Trie {
      private boolean isEnd;
      private Trie[] next;
      /** Initialize your data structure here. */
      public Trie() {
          isEnd = false;
          next = new Trie[26];
      }
      
      /** Inserts a word into the trie. */
      public void insert(String word) {
          if (word == null || word.length() == 0) return;
          Trie curr = this;
          char[] words = word.toCharArray();
          for (int i = 0;i < words.length;i++) {
              int n = words[i] - 'a';
              if (curr.next[n] == null) curr.next[n] = new Trie();
              curr = curr.next[n];
          }
          curr.isEnd = true;
      }
      
      /** Returns if the word is in the trie. */
      public boolean search(String word) {
          Trie node = searchPrefix(word);
          return node != null && node.isEnd;
      }
      
      /** Returns if there is any word in the trie that starts with the given prefix. */
      public boolean startsWith(String prefix) {
          Trie node = searchPrefix(prefix);
          return node != null;
      }
  
      private Trie searchPrefix(String word) {
          Trie node = this;
          char[] words = word.toCharArray();
          for (int i = 0;i < words.length;i++) {
              node = node.next[words[i] - 'a'];
              if (node == null) return null;
          }
          return node;
      }
  }
  ```
- 并查集
  ```java
  // Java
  class UnionFind { 
  	private int count = 0; 
  	private int[] parent; 
  	public UnionFind(int n) { 
  		count = n; 
  		parent = new int[n]; 
  		for (int i = 0; i < n; i++) { 
  			parent[i] = i;
  		}
  	} 
  	public int find(int p) { 
  		while (p != parent[p]) { 
  			parent[p] = parent[parent[p]]; 
  			p = parent[p]; 
  		}
  		return p; 
  	}
  	public void union(int p, int q) { 
  		int rootP = find(p); 
  		int rootQ = find(q); 
  		if (rootP == rootQ) return; 
  		parent[rootP] = rootQ; 
  		count--;
  	}
  }
  ```
- 启发式搜索
  ```java
  //Java
	public class AStar
	{
		public final static int BAR = 1; // 障碍值
		public final static int PATH = 2; // 路径
		public final static int DIRECT_VALUE = 10; // 横竖移动代价
		public final static int OBLIQUE_VALUE = 14; // 斜移动代价
		
		Queue<Node> openList = new PriorityQueue<Node>(); // 优先队列(升序)
		List<Node> closeList = new ArrayList<Node>();
		
		/**
		 * 开始算法
		 */
		public void start(MapInfo mapInfo)
		{
			if(mapInfo==null) return;
			// clean
			openList.clear();
			closeList.clear();
			// 开始搜索
			openList.add(mapInfo.start);
			moveNodes(mapInfo);
		}
	

		/**
		 * 移动当前结点
		 */
		private void moveNodes(MapInfo mapInfo)
		{
			while (!openList.isEmpty())
			{
				Node current = openList.poll();
				closeList.add(current);
				addNeighborNodeInOpen(mapInfo,current);
				if (isCoordInClose(mapInfo.end.coord))
				{
					drawPath(mapInfo.maps, mapInfo.end);
					break;
				}
			}
		}
		
		/**
		 * 在二维数组中绘制路径
		 */
		private void drawPath(int[][] maps, Node end)
		{
			if(end==null||maps==null) return;
			System.out.println("总代价：" + end.G);
			while (end != null)
			{
				Coord c = end.coord;
				maps[c.y][c.x] = PATH;
				end = end.parent;
			}
		}
	

		/**
		 * 添加所有邻结点到open表
		 */
		private void addNeighborNodeInOpen(MapInfo mapInfo,Node current)
		{
			int x = current.coord.x;
			int y = current.coord.y;
			// 左
			addNeighborNodeInOpen(mapInfo,current, x - 1, y, DIRECT_VALUE);
			// 上
			addNeighborNodeInOpen(mapInfo,current, x, y - 1, DIRECT_VALUE);
			// 右
			addNeighborNodeInOpen(mapInfo,current, x + 1, y, DIRECT_VALUE);
			// 下
			addNeighborNodeInOpen(mapInfo,current, x, y + 1, DIRECT_VALUE);
			// 左上
			addNeighborNodeInOpen(mapInfo,current, x - 1, y - 1, OBLIQUE_VALUE);
			// 右上
			addNeighborNodeInOpen(mapInfo,current, x + 1, y - 1, OBLIQUE_VALUE);
			// 右下
			addNeighborNodeInOpen(mapInfo,current, x + 1, y + 1, OBLIQUE_VALUE);
			// 左下
			addNeighborNodeInOpen(mapInfo,current, x - 1, y + 1, OBLIQUE_VALUE);
		}
	

		/**
		 * 添加一个邻结点到open表
		 */
		private void addNeighborNodeInOpen(MapInfo mapInfo,Node current, int x, int y, int value)
		{
			if (canAddNodeToOpen(mapInfo,x, y))
			{
				Node end=mapInfo.end;
				Coord coord = new Coord(x, y);
				int G = current.G + value; // 计算邻结点的G值
				Node child = findNodeInOpen(coord);
				if (child == null)
				{
					int H=calcH(end.coord,coord); // 计算H值
					if(isEndNode(end.coord,coord))
					{
						child=end;
						child.parent=current;
						child.G=G;
						child.H=H;
					}
					else
					{
						child = new Node(coord, current, G, H);
					}
					openList.add(child);
				}
				else if (child.G > G)
				{
					child.G = G;
					child.parent = current;
					openList.add(child);
				}
			}
		}
	

		/**
		 * 从Open列表中查找结点
		 */
		private Node findNodeInOpen(Coord coord)
		{
			if (coord == null || openList.isEmpty()) return null;
			for (Node node : openList)
			{
				if (node.coord.equals(coord))
				{
					return node;
				}
			}
			return null;
		}
	

	

		/**
		 * 计算H的估值：“曼哈顿”法，坐标分别取差值相加
		 */
		private int calcH(Coord end,Coord coord)
		{
			return Math.abs(end.x - coord.x)
					+ Math.abs(end.y - coord.y);
		}
		
		/**
		 * 判断结点是否是最终结点
		 */
		private boolean isEndNode(Coord end,Coord coord)
		{
			return coord != null && end.equals(coord);
		}
	

		/**
		 * 判断结点能否放入Open列表
		 */
		private boolean canAddNodeToOpen(MapInfo mapInfo,int x, int y)
		{
			// 是否在地图中
			if (x < 0 || x >= mapInfo.width || y < 0 || y >= mapInfo.hight) return false;
			// 判断是否是不可通过的结点
			if (mapInfo.maps[y][x] == BAR) return false;
			// 判断结点是否存在close表
			if (isCoordInClose(x, y)) return false;
	

			return true;
		}
	

		/**
		 * 判断坐标是否在close表中
		 */
		private boolean isCoordInClose(Coord coord)
		{
			return coord!=null&&isCoordInClose(coord.x, coord.y);
		}
	

		/**
		 * 判断坐标是否在close表中
		 */
		private boolean isCoordInClose(int x, int y)
		{
			if (closeList.isEmpty()) return false;
			for (Node node : closeList)
			{
				if (node.coord.x == x && node.coord.y == y)
				{
					return true;
				}
			}
			return false;
		}
	}

  ```

## 学习心得
本次学习最终要的收获就是题目不是做一遍就结束的，要用五毒神掌来练习，强化肌肉记忆，轻松应对面试。  
分享和学习别人的思维是一种好的学习办法。  
对于自己没有思路的题目不要硬磕，看别人的解题思路来学习也是很不错的。  
虚怀若谷，空杯心态，接纳比自己更优秀的方法，并吸收成为自己的。

## 开启算法之路
通过本次训练营算是正式搭上了算法的车，以后就是坚持刷题，不仅仅是为了面试，也是为了训练自己的思维能力。让自己写的代码简洁明了并且效率更高。打造自己的品牌之路，算法思维也是必须的。  
踏上这条不归路，第一步是先面试进入一家好公司，第二步坚持练习提升思维能力。
