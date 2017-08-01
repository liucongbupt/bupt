package Interview;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: Merge
 * @Description:
 * @date 2017年04月24日 下午8:23
 **/
public class Merge {
    public static void sort(int[] nums,int low,int high){
        int mid = (high-low)/2+low;
        if (low<high){
            sort(nums,low,mid);
            sort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
    }

    public static void merge(int[] nums,int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;

        while (i<=mid&&j<=high){
            if (nums[i]<nums[j]){
                temp[k++]=nums[i++];
            }else {
                temp[k++]=nums[j++];
            }
        }

        while (i<=mid){
            temp[k++]=nums[i++];
        }

        while (j<=high){
            temp[k++]=nums[j++];
        }


        for (int l = 0; l < temp.length; l++) {
            nums[low+l]=temp[l];
        }
    }


    // 归并排序的实现
    public static void main(String[] args) {

        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        System.out.println(Arrays.toString(nums));
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
