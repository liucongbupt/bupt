package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No31NextPermutation
 * @Description:
 * @date 2017年04月24日 下午11:46
 **/
public class No31NextPermutation {
    public  void nextPermutation(int[] nums) {
        int index = -1;
        for(int i = nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                index = i-1;
                break;
            }
        }

        if(index!=-1){
            for(int i = nums.length-1;i>index;i--){
                if(nums[i]>nums[index]){
                    int temp = nums[index];
                    nums[index]= nums[i];
                    nums[i]=temp;
                    break;
                }
            }

        }
        reverse(nums,index+1,nums.length-1);
        return;
    }

    void reverse(int[] nums,int start,int end){
        while(start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {3,2,1};
        int[] c = {1,1,5};
    }
}
