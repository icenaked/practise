package judge;

public class HeapSort {
    //堆排序
    public static void main(String[] args){
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void heapSort(int[] arr) {
        // 首先，构建最小堆（降序，升序用最大堆）
        buildMinHeap(arr);
        // 依次取出堆顶元素（最小值），放到数组的末尾，并重新调整堆结构
        for (int i = arr.length - 1; i >= 0; i--) {
            // 将当前堆顶元素（最小值）与数组末尾元素交换
            swap(arr, 0, i);
            // 重新调整堆结构（不包括已经排序好的末尾元素）
            minHeapify(arr, i, 0);
        }
    }
    private static void buildMinHeap(int[] arr) {
        int n = arr.length;
        // 最后一个非叶子节点的索引是 (n-1)/2 的向下取整
        for (int i = (n - 1) / 2; i >= 0; i--) {
            minHeapify(arr, n, i);
        }
    }
    private static void minHeapify(int[] arr, int n, int i) {
        int smallest = i; // 初始化最小值为当前节点
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点
        // 如果有左子节点，并且左子节点小于当前节点，则更新最小值为左子节点
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }
        // 如果有右子节点，并且右子节点小于当前已知的最小值，则更新最小值为右子节点
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }
        // 如果最小值不是当前节点，则交换这两个节点，并继续调整堆结构
        if (smallest != i) {
            swap(arr, i, smallest);
            minHeapify(arr, n, smallest);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
