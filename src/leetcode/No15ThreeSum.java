package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.No15ThreeSum
 * @Description:
 * @date 2017年04月18日 下午11:34
 **/
public class No15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        if(nums==null||nums.length<3)
            return rtn;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {
                    int sum = nums[l] + nums[r]+nums[i];
                    if (sum  == 0) {
                        List<Integer> triple = new ArrayList<Integer>();
                        triple.add(nums[i]);
                        triple.add(nums[l]);
                        triple.add(nums[r]);
                        rtn.add(triple);
                        r--;
                        l++;

                        //handle duplicate here
                        while(l<r && nums[l]==nums[l-1])
                            l++;
                        while(l<r && nums[r]==nums[r+1])
                            r--;
                    } else if(sum<0){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return rtn;
    }

}
