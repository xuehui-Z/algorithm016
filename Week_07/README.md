# 学习笔记 第七周
### 知识点
- **字典树（Trie）**   
  在现实中主要用于单词搜索，以及单词联想输入。他的结构主要包括两个定义，1：定义当前节点保存的单个字符，以及他的下一个字符的指向；2：有可能某个单词是包含在另一个单词的里面，所以需要一个定义该节点是不是一个单词的结尾。  
  基本操作：插入一个单词，搜索一个单词，搜索单词前缀...  
  -- 代码模板如下  
  ```java
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
- **并查集**  
  在现实中主要用于组合，配对的实现  
  基本操作：  
  1.makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合。  
  2.unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在
的集合不相交，如果相交则不合并。  
  3.find(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元
素是否位于同一个集合，只要将它们各自的代表比较一下就可以了  
  --代码模板：  
  ```java
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
- **剪枝**  
  主要思想就是在循环递归的时候，今早判断出没有必要的分支，类似于括号生成问题中，每次循环的开始就把条件规定好，生成括号的规则是左括号大于等于右括号，这样就会把生成无效括号的分支剪掉，提高程序效率。  
- **双向BFS搜索**  
  从开始位置和结束位置同时开始搜索，每次选择需要遍历最少的开始，直到两个遍历集合重合，即找到问题的解。  
- **启发式搜索**  
  启发式搜索的关键是定义估价函数  
  启发式函数： h(n)，它用来评价哪些结点最有希望的是一个我们要找的结点，h(n) 会返回一个非负实数,也可以认为是从结点n的目标结点路径的估计成本。  
  启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标。
-  **AVL树**  
  AVL树是一种平衡二叉树(即左子树高度和右子树高度不会相差一个数值，这个数值我们称之为平衡因子)，它主要通过四种旋转操作来维护树的平衡  
    1. 左旋（右右子树）  
	2. 右旋（左左子树）  
	3. 左右旋（左右子树）  
	4. 右左旋（右左子树）  
- **红黑树**  
  红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树：   
    1. 每个结点要么是红色，要么是黑色  
	2. 根结点是黑色  
	3. 每个叶结点（NIL结点，空结点）是黑色的。  
    4. 不能有相邻接的两个红色结点 
	5. 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。 
	
  因为有了以上五点要求，红黑树保证了从根到叶子的最长的可能路径不多于最短的可能路径的两倍长。
- **AVL和红黑树的对比**
  - AVL trees providefaster lookups than Red Black Trees because they are more strictly balanced.(因为AVL更家的平衡，所以它的搜索比红黑树更有效)   
  - Red Black Trees providefaster insertion and removal operations than AVL trees as fewer rotations are done due to relatively relaxed balancing.(因为红黑树旋转操作比AVL少，所以他的新增和删除比AVL更有效)  
  - AVL trees storebalance factors or heightswith each node, thus requires storage for an integer per node whereas Red Black Tree requires only 1 bit of information per node.(AVL中每个节点有一个Integer类型的字段保存平衡因子，红黑树中每个节点有一个Byte类型的字段记录颜色)
  - Red Black Trees are used in most of the language libraries likemap, multimap, multisetin C++ whereas AVL trees are used in databases where faster retrievals are required.(红黑树经常被用于一些语言的类库中，类似于Java的HashMap,AVL常被用于要去读操作多的数据库中)

  
