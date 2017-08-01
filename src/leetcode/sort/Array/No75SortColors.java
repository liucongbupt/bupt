package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No75SortColors
 * @Description:
 * @date 2017年02月14日 下午1:25
 **/

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?
 Subscribe to see which companies asked this question.

 Hide Tags leetcode.Array Two Pointers leetcode.Sort
 Hide Similar Problems (M) leetcode.Sort List (M) Wiggle leetcode.Sort (M) Wiggle leetcode.Sort II

 */
public class No75SortColors {
    public No75SortColors() {
    }
    public void sortColors(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                a++;
            }else if(nums[i]==1){
                b++;
            }else if(nums[i]==2){
                c++;
            }
        }
        for (int i = 0; i < a; i++) {
            nums[i] = 0;
        }
        for (int i = a; i < a+b; i++) {
            nums[i] = 1;
        }
        for (int i = a+b; i < a+b+c; i++) {
            nums[i] = 2;
        }

    }
    public static void main(String[] args) {

    }
}
