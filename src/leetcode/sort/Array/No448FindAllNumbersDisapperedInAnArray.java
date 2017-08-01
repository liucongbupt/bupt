package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No448FindAllNumbersDisapperedInAnArray
 * @Description:
 * @date 2017年02月26日 上午8:08
 **/

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]
 Subscribe to see which companies asked this question.

 Hide Tags leetcode.Array
 Hide Similar Problems (H) First Missing Positive (M) Find All Duplicates in an leetcode.Array

 */
public class No448FindAllNumbersDisapperedInAnArray {
    public No448FindAllNumbersDisapperedInAnArray() {
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i])-1;
            if(nums[temp]>0){
                nums[temp] = -nums[temp];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                result.add(i+1);
            }
        }
        return  result;
    }
    public static void main(String[] args) {

    }
}
