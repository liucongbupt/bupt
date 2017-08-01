package leetcode;

/**
 * Created by liucong on 2017/5/10.
 */
public class No80RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
