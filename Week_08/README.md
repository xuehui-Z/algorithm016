# 学习笔记
### 位运算
- **int类型的二进制表示**  
  Java中int类型占4个字节，每个字节8位，所以总共32位  
  int类型是有符号数，最高位代表符号，所以int类型表示最大的正整数是【01111111 11111111 11111111 11111111】，也就是十进制的2147483647.  
  二进制负数的表示方式是采用反码加补码的方式，例如：
  -5的二进制就是5的二进制取反（得到反码），再加1（得到补码）。  
  元码:[00000000 00000000 00000000 00000101]  
  反码:[11111111 11111111 11111111 11111010]  
  补码:[11111111 11111111 11111111 11111011]  
  所以-5的二进制表示形式就是上面的补码
- **位运算符**   
	| 运算名称 | 运算符 | 实例         |  
	| ---      | --     | --           |  
    | 左移     | <<     | 0011 -> 0110 |  
	| 右移     | >>     | 0011 -> 0001 |   
	| 按位或   | \|     | 0011 \| 0110  -> 0111 |    
	| 按位与   | &      | 0011 & 0110  -> 0010 |    
	| 按位取反 | ~      | 0011 -> 1100 |    
	| 按位异或（相同为零不同为一） | ^      | 0011 ^ 0110 -> 0111 |    
- **常用计算操作**
    x ^ 0 = x  
	x ^ 1s = ~x // 注意 1s = ~0  
	x ^ (~x) = 1s  
	x ^ x = 0  
	c = a ^ b => a ^ c = b, b ^ c = a // 交换两个数  
	a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c // associative  
	• 判断奇偶：  
	    x % 2 == 1 —> (x & 1) == 1  
		x % 2 == 0 —> (x & 1) == 0  
	• x >> 1 —> x / 2.  
		即： x = x / 2; —> x = x >> 1;  
		mid = (left + right) / 2; —> mid = (left + right) >> 1;  
	• X = X & (X-1) 清零最低位的 1  
	• X & -X => 得到最低位的 1  
	• X & ~X => 0   
### 排序算法
  十种常见排序算法可以分为两大类：  
  比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。  
  非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。   
  详细参考： https://www.cnblogs.com/onepixel/p/7674659.html
- **冒泡排序**  
  比较相邻的元素。如果第一个比第二个大，就交换它们两个；  
  对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；  
  针对所有的元素重复以上的步骤，除了最后一个；  
  重复步骤1~3，直到排序完成。  
  ```java
     public static int[] bubbleSort(int[] array) {
          if (array.length == 0) return array;
         for (int i = 0; i < array.length; i++)
             for (int j = 0; j < array.length - 1 - i; j++)
                 if (array[j + 1] < array[j]) {
                     int temp = array[j + 1];
                     array[j + 1] = array[j];
                     array[j] = temp;
                 }
         return array;
     }
  ```
- **选择排序**  
  n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：  
  初始状态：无序区为R[1..n]，有序区为空；  
  第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；  
  n-1趟结束，数组有序化了。  
  ```java
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
  ```  
- **插入排序**   
  一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：  
  从第一个元素开始，该元素可以认为已经被排序；  
  取出下一个元素，在已经排序的元素序列中从后向前扫描；  
  如果该元素（已排序）大于新元素，将该元素移到下一位置；  
  重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；  
  将新元素插入到该位置后；  
  重复步骤2~5。  
  ```java
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
  ```  
- **并归排序**  
  把长度为n的输入序列分成两个长度为n/2的子序列；  
  对这两个子序列分别采用归并排序；  
  将两个排序好的子序列合并成一个最终的排序序列。  
  ```java
    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
  ```  
-- **快速排序**  
  从数列中挑出一个元素，称为 “基准”（pivot）；  
  重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；  
  递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。  
  ```java
    /**
     * 快速排序方法
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
        return array;
    }
    /**
     * 快速排序算法——partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
  ```  
- **堆排序**
  一般使用大顶堆实现升序排序；使用小顶堆实现降序排序。
  Step1.构筑堆
   利用递归思想，只考虑一个二叉树的情况，判断根节点是否大于它的左右节点，不是的话，就将根节点和最大的节点交换，并且重新构筑被交换的子节点。  
   从最后一个非叶子节点(对应到数组中下标为n/2-1，n为数组长度)开始，依次构筑根节点  
   遍历结束后，既可以将一个无序数组转化为一个大顶堆。则最大值再Root节点位置，即arr[0]。  
   Step2.将最大值(arr[0])和数组最后一个值交换，重新构筑堆(不考虑最后一个值)  
   因为Step1的时候已经将所有子树都转化成大顶堆了，所以在只换了Root节点的情况下，只要重新构筑Root节点即可。
   重复Step2，直到所有数值都排好序。  

  ```java
  public class heapUtil {
  
  	//测试用主方法
      public static void main(String[] args) {
          int[] arr = {4,6,2,3,9,7,6,0,2,5};
          heapUtil hu = new heapUtil();
          arr = hu.heapsort(arr);
          printArr(arr);
      } 
  	//测试用输出方法
      private static void printArr(int[] arr) {
          for ( int i : arr) System.out.print(i+" ");
          System.out.println();
      }
  
  	//堆排序方法入口
      public int[] heapsort(int[] arr) {
          int n = arr.length;
  
  		//构筑堆
          for (int i=n/2-1;i>=0;i--) { //从最后一个非叶子节点开始，(n/2-1，代表最后一个非叶子节点的下标)
              heapdef(arr,i,n-1);
          }
  		//将最大值(arr[0])和数组最后一个值交换，并重新构筑堆
          for (int i=n-1;i>0;i--) {
              int temp = arr[0];
              arr[0] = arr[i];
              arr[i] = temp;
              heapdef(arr,0,i-1); //堆顶元素与末尾值交换(将最大值放在数字最后)，重新构筑堆(长度减1，不考虑最后的最大值)
          }
  
          return arr;
      }
  
  	//堆排序构筑(大顶堆)
      public void heapdef(int[] arr, int start, int end) { //start，end代表需要构筑堆在数组中下标的起始位置
          if (end > arr.length-1) return; //需要调整的堆的长度超出数组长度
          int root = start;
          int left = root*2 + 1,right = root*2 + 2;
          if (left  <= end && arr[root] < arr[left])  root = left;  //构筑大顶堆，所以当arr[root] < arr[left] 时，交换节点下标
          if (right <= end && arr[root] < arr[right]) root = right; //构筑大顶堆，所以当arr[root] < arr[right]时，交换节点下标
          if (root != start) {
              int swp = arr[start];
              arr[start] = arr[root];
              arr[root] = swp;
              heapdef(arr,root,end);
          }
  
      }
  }
  ```
- **桶排序**  
  人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）；  
  遍历输入数据，并且把数据一个一个放到对应的桶里去；  
  对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；  
  从不是空的桶里把排好序的数据拼接起来。  
  ```java
    /**
     * 桶排序
     * 
     * @param array
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) { // 如果带排序数组中有重复数字时  感谢 @见风任然是风 朋友指出错误
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }
  ```  