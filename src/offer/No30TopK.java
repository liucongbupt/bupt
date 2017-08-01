package offer;

import arg4.Graph.SymbolGraph;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liucong
 * @ClassName: No30TopK
 * @Description:
 * @date 2017年04月02日 下午2:47
 **/
public class No30TopK {
    public static int[] getLeastNumber(int[] nums,int k){
        if (!checkValidArray(nums))
            return null;
        int start = 0;
        int end = nums.length-1;
        int index = partition(nums,start,end);
        while (index!=(k-1)){
            if(index>(k-1)){
                end =index-1;
            }else{
                start=index+1;
            }
            index = partition(nums,start,end);
        }
        int[] rtn  = new int[k];
        for (int i = 0; i < k; i++) {
            rtn[i]=nums[i];
        }
        return rtn;
    }
    public static boolean checkValidArray(int[] nums){
        if(nums==null||nums.length<=0)
            return false;
        return true;
    }

    private static int partition(int[] nums,int start,int end){
        int tmp = nums[start];

        while (start<end){
            while (start<end&&nums[end]>=tmp) end--;
            nums[start]=nums[end];
            while (start<end&&nums[start]<=tmp) start++;
            nums[end]=nums[start];
        }
        nums[start] = tmp;
        return start;
    }
    public static void swap(int[] str,int i,int j){
        int temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static int[] getLeastNumberK(int[] nums,int k ){
        if (nums==null||k>nums.length||k<1){
            return null;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.isEmpty()||maxHeap.size()<k){
                maxHeap.add(nums[i]);
            }else{
                if(maxHeap.peek()>nums[i]){
                    maxHeap.remove();
                    maxHeap.add(nums[i]);
                }
            }
        }
        int[] rtn =new int[k];
        for (int i = 0; i < k; i++) {
            rtn[i] = maxHeap.poll();
        }
        return rtn;
    }
    public static void main(String[] args) {
        int[] a = {1,2,4,5,7,8,4,2};
        int[] b = {1,2,4,5,7,8,9,11};
        int[] c = {2};
        int[] d = {};
//        int[] rtn = getLeastNumberK(a,0);
        int[] rtn = getLeastNumber(a,1);
        for (int i = 0; i < rtn.length; i++) {
            System.out.print(rtn[i]+" ");
        }
    }

}
