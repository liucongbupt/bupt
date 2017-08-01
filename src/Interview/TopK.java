package Interview;

/**
 * Created by liucong on 2017/5/16.
 */
public class TopK {

    /**
     * 创建k个节点的小根堆
     *
     * @param a
     * @param k
     * @return
     */
    /**
     * Quick
     * @param a
     * @param k
     * @return
     */
    public int[] topKByPartition(int[] a, int k) {
        int start = 0;
        int end = a.length-1;
        int idx = partion(a,start,end);
        while (idx!=k-1){
            if (idx>k-1){
                end = idx-1;
            }else {
                start = idx+1;
            }
            idx = partion(a,start,end);
        }
        int[] rtn = new int[k];
        for (int i = 0; i < k; i++) {
            rtn[i] = a[i];
        }
        return rtn;
    }

    public int partion(int[] a,int start,int end){
        int partion=a[start];
        while (start<end){
            while (end>start&&a[end]>=partion) end--;
            a[start] = a[end];
            while (start<end&&a[start]<=partion) start++;
            a[end] = a[start];
        }
        a[start] = partion;
        return start;
    }
    /**
     * Heap
     * @param a
     * @param k
     * @return
     */
    public int[] topKByHeap(int[] a, int k) {
        int[] heap = new int[k + 1];
        heap = createHeap(a, k);
        for (int i = k; i < a.length; i++) {
            if (a[i] > heap[1]) {
//                insert(heap, a[i]);
                heap[1] = a[i];
                sink(heap,1,heap.length);
            }
        }
        return heap;
    }

    public void insert(int[] heap,int tmp){
        heap[1] = tmp;
        sink(heap,1,heap.length);
    }
    public int[] createHeap(int[] a, int k) {
        int[] rtn = new int[k + 1];
        for (int i = 0; i < k; i++) {
            rtn[i + 1] = a[i];
        }
        int N = rtn.length;
        for (int i = N / 2; i >= 1; i--) {
             sink(rtn,i,N);
        }
        return rtn;
    }

    public void sink(int[] a,int k,int N){
        while (2*k<N){
            int j = 2*k;
            if (j+1<N&&a[j]>a[j+1]) j++;
            if (a[k]<=a[j]) break;
            swap(a,k,j);
            k = j;
        }
    }

    public void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i]=a[j];
        a[j]=tmp;
    }

    public static void main(String[] args) {
        TopK tse = new TopK();
        int a[] = { 4, 3, 5, 1, 2,8,9,10};
        int result[] = tse.topKByHeap(a, 3);
        for (int i = 1; i <= 3; i++) {
            System.out.print(result[i]+" ");
        }
        System.out.println();
        int result1[] = tse.topKByPartition(a, 3);
        for (int i = 0; i < 3; i++) {
            System.out.print(result1[i]+" ");
        }
    }
}
