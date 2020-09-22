# 堆排序(HeapSort)学习总结

### 堆排序的前提

### 代码实现
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

        for (int i=n/2-1;i>=0;i--) { //从最后一个非叶子节点开始，(n/2-1，代表最后一个非叶子节点的下标)
            heapdef(arr,i,n-1);
        }

        for (int i=n-1;i>0;i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapdef(arr,0,i-1); //堆顶元素与末尾值交换(将最大值放在数字最后)，重新构筑堆(长度减1，不考虑最后的最大值)
        }

        return arr;
    }

	//堆排序构筑(大顶堆)
    public void heapdef(int[] arr, int start, int end) {
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