package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No228SummaryRanges
 * @Description:
 * @date 2017年03月02日 上午11:18
 **/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all leetcode.Sort cases.

 Subscribe to see which companies asked this question.

 Hide Tags leetcode.Array
 Hide Similar Problems (M) Missing Ranges (H) Data Stream as Disjoint Intervals

 */
public class No228SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int front  = nums[i];
            String s = Integer.toString(front);
            while (i+1<nums.length&&nums[i+1]==nums[i]) i++;

            if(nums[i]!=front){
                res.add(s+"->"+Integer.toString(nums[i]));
            }else{
                res.add(s);
            }
        }
        return res;
    }
}
