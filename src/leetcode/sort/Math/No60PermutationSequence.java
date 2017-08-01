package leetcode.sort.Math;

/**
 * @author liucong
 * @ClassName: No60PermutationSequence
 * @Description:
 * @date 2016年10月17日 4:33 PM
 **/

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.

 Subscribe to see which companies asked this question

 Hide Tags leetcode.Backtracking leetcode.Math
 Hide Similar Problems (M) Next Permutation (M) Permutations

 */
public class No60PermutationSequence {
    public No60PermutationSequence() {
    }
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=i+1;
        }
        for (int i = 1; i < k; i++) {
            nextPermutation(nums);
        }
        String rtn="";
        for (int i = 0; i < nums.length; i++) {
            rtn=rtn+Integer.toString(nums[i]);
        }
        return rtn;
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
    public String getPermutationEx(int n, int k) {
        String rtn = "";
        boolean[] used = new boolean[n];

        k--;
        int factor = 1;
        for (int i = 0; i < n; i++) {
            factor *= i;
        }

        for (int i = 0; i < n; i++) {
            int index = k/factor;
            k%=factor;
            for (int j = 0; j < n; j++) {
                if(used[j]==false){
                    if(index==0){
                        used[j] = true;
                        rtn += Integer.toString(j);
                    }else{
                        index--;
                    }
                }
            }
            if(i<n-1){
                factor = factor/(n-1-i);
            }
        }
        return rtn;
    }
    public static void main(String[] args) {
        No60PermutationSequence ps = new No60PermutationSequence();
        System.out.println(ps.getPermutationEx(3,2));
    }
}
