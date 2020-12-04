# HashMap小节  
### Hash算法简介
- **Hash算法**是把任意长度的输入值，返回固定长度的输出值。通常输出值的长度远小于输入值的长度，所以这是一种压缩映射。
- **Hash冲突**是指两个不同的输入值，返回的是相同的输出值。  

### HashMap结构  
- HashMap实际上是一个Node结构的**数组**。  
 `transient Node<K,V>[] table;`   
- HashMap的默认**初始容量**：  
  `static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16.`
- HashMap的**最大容量**：  
  `static final int MAXIMUM_CAPACITY = 1 << 30; //十亿多。`
- HashMap的**容量**：  
  `transient int size;  //每次有新数据插入时，size+1。`
- HashMap的默认**加载因子**：  
  `static final float DEFAULT_LOAD_FACTOR = 0.75f; //提高空间利用率和 减少查询成本的折中，主要是泊松分布，0.75的话碰撞最小`  
  - 加载因子是判断是否需要扩容的依据，当size大于加载因子*当前容量的时候，就会进行扩容处理。  
  - HashMap有两个参数影响其性能：**初始容量和加载因子**。容量是哈希表中桶的数量，初始容量只是哈希表在创建时的容量。加载因子是哈希表在其容量自动扩容之前可以达到多满的一种度量。当哈希表中的条目数超出了加载因子与当前容量的乘积时，则要对该哈希表进行扩容、rehash操作（即重建内部数据结构），扩容后的哈希表将具有两倍的原容量  
- **Node的结构**  
  Class Node作为HashMap中保存数据的主题，主要是有Key，Value以及指向下一个节点的next指针和用来计算下标值得hash值。
   ```java
   static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
		...
   }
   ``` 
  其中next指针构成了一个**链表**，是为了解决Hash冲突用的，当出现Hash冲突时，会把冲突的值保存在链表中。 
- **TreeNode的结构**   
  TreeNode是Java1.8中做的修改，当Node链表的长度超过指定值时，会把Node链表转变为TreeNode，TreeNode是红黑树。
	```java
	static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
        TreeNode<K,V> parent;  // red-black tree links
        TreeNode<K,V> left;
        TreeNode<K,V> right;
        TreeNode<K,V> prev;    // needed to unlink next upon deletion
        boolean red;
        TreeNode(int hash, K key, V val, Node<K,V> next) {
            super(hash, key, val, next);
        }
		...
	}
	```
	红黑树的特点  
  1.每个结点要么是红色，要么是黑色  
  2.根结点是黑色  
  3.每个叶结点（NIL结点，空结点）是黑色的。  
  4.不能有相邻接的两个红色结点  
  5.从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。  
  基于以上特点，能保证整个树的结构是平衡的，每次寻找对应的值不会出现极限化   
### HashMap构造方法
- **无参构造方法**使用默认的初始容量的加载因子。
    ```java
    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }
    ```
- **指定初始容量**，使用默认加载因子。
	```java
	public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }
	```
- **指定容量和加载因子**，当指定的值小于零或者加载因子不合法时抛出异常，当指定的初始容量大于最大容量时，使用最大容量。
	```java
	public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }
	```
- 构造一个新的HashMap，并将另一个Map保存到新的HashMap中。
	```java
	public HashMap(Map<? extends K, ? extends V> m) {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        putMapEntries(m, false);
    }
	```
### HashMap常用方法
- **get方法**  
  因为HashMap是数组+链表(红黑树)的形式，所以get方法首先是根据Key的Hash值找到数组下标，再遍历数组或者树来找到相应的Key值返回。
	```java
	final Node<K,V> getNode(int hash, Object key) { //传入的hash是要寻找的Key的Hash（getNode(hash(key), key)）
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {  //先判断数组是否为空，再判断这个Key的Hash对应的数组位置是否为空
            if (first.hash == hash && // always check first node //Key的Hash值判断
                ((k = first.key) == key || (key != null && key.equals(k))))  //Key的Value值判断
                return first;  //KeyHash值和Value值都一样就找到了
            if ((e = first.next) != null) {  //否则就便利数组
                if (first instanceof TreeNode)  //如果是红黑树了，就从树中找
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {  //如果不是树，就遍历数组，知道找到Key的Hash值和Value值都一样的对象。
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
	```
- **Put方法**  
  1. 计算Key的Hash值；  
  2. 通过Hash值和Node数组的长度-1进行与运算，得到数组下标index；  
  3. 如果数组下标index的位置是空的，则不存在Hash冲突，将对象放入该位置，结束。  
  4. 如果数组下标index的位置不为空，判断该位置的Key和要插入的Key的Hash值和Value值，  
  - 4.1. 如果相同，则把该位置的Value值替换成传入的Value值，并返回老的Value值。 
  - 4.2. 如果不相同则判断当前位置是不是树，如果是树，就把传入的Key和Value插入到树中。如果不是插入链表中，再判断链表长度是否到了指定的长度(static final int TREEIFY_THRESHOLD = 8;)，是的话再把链表转化成红黑树。  
  5. 如果数组长度大于加载因子*当前容量，则进行扩容处理。  	
	```java
	final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;  //如果数组为空，进行扩容处理，初始化HashMap
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
	```  
- **扩容机制**  
  1. 如果原来数字容量大于等于最大容量，直接返回原来数组。  
  2. 创建一个新数组，容量为原来的两倍. `(newCap = oldCap << 1) < MAXIMUM_CAPACITY`，并且扩容后容量要小于最大容量。  
     新的加载因子也变为原来的两倍。  
  3. 遍历原来的数组，将旧数组的对象存放到新的数组中。  
    3.1 如果Node没有next，直接重新计算下标，放入。  
    3.2 如果Node是树，遍历树中的元素，重新计算下标值，将其放入新数组中。`((TreeNode<K,V>)e).split(this, newTab, j, oldCap);`  
    3.3 如果Node不是树，遍历链表中的元素，重新计算下标值，放入。
	






