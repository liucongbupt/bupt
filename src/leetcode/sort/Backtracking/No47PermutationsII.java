package leetcode.sort.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.Backtracking.No47PermutationsII
 * @Description:
 * @date 2016年10月03日 10:08 PM
 **/
public class No47PermutationsII {
    public No47PermutationsII() {
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i < 0)
                break;

            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
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
//            if(!rtn.contains(list))
            rtn.add(list);
        }
        return rtn;
    }
    public static void main(String[] args) {
        No47PermutationsII pm = new No47PermutationsII();
        List<List<Integer>> rtn = pm.permuteUnique(new int[]{1, 1, 3});
        for (List<Integer> a : rtn) {
            System.out.println(a);
        }

    }
}
