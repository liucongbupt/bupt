package Interview; /**
 * @author liucong
 * @ClassName: leetcode.Sort
 * @Description:
 * @date 2017年03月06日 下午4:01
 **/

/**
 * 排序
 * 插入排序：直接插入 稳 o(n2)
 *          希尔排序 不稳 o(n1.5)
 * 选择排序：直接排序 不稳 o(n2)
 *          堆排序 不稳 o(nlgn)
 * 交换排序：冒泡排序 稳 o(n2)
 *          快速排序 不稳 o(nlgn)
 * 归并排序： 稳 o(nlgn)
 */
public class Sort {


    /**
     * Bubble
     *
     * @param arr
     */
    private void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1, arr);
            }
        }
    }

    /**
     * Quick
     *
     * @param arr
     * @param start
     * @param end
     */
    private void QucikSort(int[] arr, int start, int end) {
        if (end <= start) return;
        else {
            int partion = partion(arr, start, end);
            QucikSort(arr, start, partion - 1);
            QucikSort(arr, partion + 1, end);

        }
    }

    private int partion(int[] arr, int low, int high) {
        int partion = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= partion) --high;
            arr[low] = arr[high];
            while (low < high && arr[low] <= partion) ++low;
            arr[high] = arr[low];
        }
        //扫描完成，枢轴到位
        arr[low] = partion;
        return low;
    }

    //QucikSort||
    private void QucikSort2(int[] arr, int low, int high) {
        if (low >= high) return;
        else {
            int pivot = pivot(arr, low, high);
            QucikSort2(arr, low, pivot - 1);
            QucikSort2(arr, pivot + 1, high);
        }
    }

    private int pivot(int[] arr, int low, int high) {
        int i = low;
        int j = high + 1;
        int pivot = arr[low];
        while (true) {
            while (arr[++i] < pivot) ;
            while (arr[--j] > pivot) ;
            if (i >= j) break;
            swap(i, j, arr);
        }
        swap(low, j, arr);
        return j;
    }

    /**
     * Select
     *
     * @param arr
     */
    private void SelectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[k])
                    k = j;
            }
            swap(i, k, arr);
        }
    }

    /**
     * Insert
     *
     * @param arr
     */
    private void InsertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = 0;
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    /**
     * Shell
     * @param arr
     */
    private  void ShellSort(int[] arr){
        if(arr==null||arr.length==0){
            return;
        }
        int increment = arr.length/2;
        while(increment>=1){
            for (int i = 0; i < arr.length; i++) {

                for (int j = i; j < arr.length-increment  ; j+=increment) {
                    if(arr[j]>arr[j+increment])
                        swap(j,j+increment,arr);
                }
            }
            increment/=2;
        }
    }

    private static void ShellSort2(int[] data) {
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i; j >= increment; j -= increment) {
                    if (temp > data[j - increment])//如想从小到大排只需修改这里
                    {
                        data[j] = data[j - increment];
                    } else {
                        break;
                    }

                }
                data[j] = temp;
            }

        }
    }

    /**
     * HeapSort
     * @param arr
     */
    private void HeapSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            buildMaxHeap(arr, arr.length-1-i);
            swap(0,arr.length-1-i,arr);
        }
    }
    private void buildMaxHeap(int[] arr,int lastIndex){
        for (int i = (lastIndex-1)/2; i >=0 ; i--) {
            int k = i;
            while (2*k+1<=lastIndex){
                int biggerIndex=2*k+1;
                if(biggerIndex<lastIndex){
                    if(arr[biggerIndex]<arr[biggerIndex+1]){
                        biggerIndex++;
                    }
                }
                if(arr[k]<arr[biggerIndex]){
                    swap(k,biggerIndex,arr);
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }

    /**
     *
     * @param arr
     */
    private void MergeSort(int[] arr,int low,int high){
        if(low<high){
            int mid = (high+low)/2;
            MergeSort(arr,low,mid);
            MergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
        return;
    }

    private void merge(int[] arr,int low,int mid,int high){
        int i = low;
        int j = mid+1;
        int k = 0;
        int[] temp = new int[high-low+1];

        while(i<=mid&&j<=high){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }

        while (i<=mid){
            temp[k++]=arr[i++];
        }

        while (j<=high){
            temp[k++]=arr[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            arr[l+low]=temp[l];
        }


    }


    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Sort Sort = new Sort();
        int[] t = new int[]{2, 1, 4, 5, 7, 1, 3};
//        leetcode.Sort.BubbleSort(t);
//        leetcode.Sort.QucikSort2(t,0,t.length-1);
//            leetcode.Sort.SelectSort(t);
//        leetcode.Sort.InsertSort(t);
//        leetcode.Sort.ShellSort(t);
        Sort.HeapSort(t);
//        leetcode.Sort.MergeSort(t,0,t.length-1);
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]);
        }
    }
}
