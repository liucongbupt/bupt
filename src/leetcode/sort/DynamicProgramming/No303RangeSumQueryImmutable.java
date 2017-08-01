package leetcode.sort.DynamicProgramming;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: No303RangeSumQueryImmutable
 * @Description:
 * @date 2017年04月07日 下午3:55
 **/
public class No303RangeSumQueryImmutable {
    public class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            for(int i = 1; i < nums.length; i++)
                nums[i] += nums[i - 1];

            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            if(i == 0)
                return nums[j];

            return nums[j] - nums[i - 1];
        }
    }
}
