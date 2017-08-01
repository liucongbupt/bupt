package leetcode.sort.Array;

/**
 * Created by liucong on 9/27/16.
 */

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 Subscribe to see which companies asked this question

 Hide Tags leetcode.Array
 Hide Similar Problems (M) Permutations (M) Permutations II (M) Permutation Sequence (M) Palindrome Permutation II

 */
public class No31NextPermutation {

    public No31NextPermutation() {

    }

    public void nextPermutation(int[] nums) {
        int partition = 0;
        for (int i = nums.length-1; i > 0; i--) {
            if(nums[i]>nums[i-1]){
                partition = i-1;
                break;
            }
        }
        for (int i = nums.length-1; i >= partition; i--) {
            if(nums[i]>nums[partition]){
                int temp = nums[i];
                nums[i] = nums[partition];
                nums[partition] = temp;
                break;
            }
        }
        reverse(nums,partition+1,nums.length-1);
        
    }

    public void reverse(int[] nums,int i,int j){
        int start = i;
        int end = j;
        for (; start < end ; start++,end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
    public static void main(String[] args) {
        No31NextPermutation a = new No31NextPermutation();
        int[] array = new int[]{1,2,3};
        a.nextPermutation(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
