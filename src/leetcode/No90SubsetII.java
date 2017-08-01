package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.No90SubsetII
 * @Description:
 * @date 2017年04月23日 下午4:03
 **/
public class No90SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rtn = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        backtracking(rtn,list,nums,0);
        return rtn;
    }

    public void backtracking(List<List<Integer>> rtn,List<Integer> list,int[] nums,int idx){
        rtn.add(new LinkedList<Integer>(list));
        for(int i = idx;i<nums.length;i++){
            if(i!=idx&&nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            backtracking(rtn,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
