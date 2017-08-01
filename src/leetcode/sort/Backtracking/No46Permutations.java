package leetcode.sort.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.Backtracking.No46Permutations
 * @Description:
 * @date 2016年10月03日 4:58 PM
 **/

/**
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 Subscribe to see which companies asked this question

 Hide Tags leetcode.Backtracking
 Hide Similar Problems (M) Next Permutation (M) Permutations II (M) Permutation Sequence (M) Combinations

 */
public class No46Permutations {

    public No46Permutations() {

    }

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        if(nums==null) return rtn;
        List<Integer> comtemp = new ArrayList<Integer>();
        for (int k = 0; k < nums.length; k++) {
            comtemp.add(nums[k]);
        }
        rtn.add(comtemp);
        while (true) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] > nums[i + 1]) {
                i--;
            }
            if (i < 0)
                break;

            int j = nums.length - 1;
            while (nums[j] < nums[i]) {
                j--;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            int low = i + 1;
            int high = nums.length - 1;
            int arrtemp = 0;
            while (low < high) {
                arrtemp = nums[low];
                nums[low] = nums[high];
                nums[high] = arrtemp;
                low++;
                high--;
            }
            List<Integer> list = new ArrayList<Integer>();
            for (int k = 0; k < nums.length; k++) {
               list.add(nums[k]);
            }
            rtn.add(list);
        }
        return rtn;
    }

    public static void main(String[] args) {
        No46Permutations pm = new No46Permutations();
        List<List<Integer>> rtn = pm.permute(new int[]{1, 2, 3});
        for (List<Integer> a : rtn) {
            System.out.println(a);
        }
    }
}
