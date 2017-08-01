package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No80RemoveDuplicatesfromSortedArrayII
 * @Description:
 * @date 2017年02月27日 下午7:23
 **/

/**
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

 Subscribe to see which companies asked this question.
 */
public class No80RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int cur =0;
        int i,j;
        for(i =0;i<nums.length;){
            int now = nums[i];
            for (j = i; j < nums.length; j++) {
                if(nums[j]!=now){
                    break;
                }
                if(j-i<2){
                    nums[cur++]=now;
                }
            }
            i=j;
        }
        return cur;
    }

    public static void main(String[] args) {
        No80RemoveDuplicatesfromSortedArrayII s= new No80RemoveDuplicatesfromSortedArrayII();
        System.out.println(        s.removeDuplicates(new int[]{1,1,1}
        ));
    }
}
