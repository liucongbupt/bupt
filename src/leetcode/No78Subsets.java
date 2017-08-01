package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.No78Subsets
 * @Description:
 * @date 2017年04月23日 下午3:50
 **/
public class No78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rtn = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        backtracking(rtn,list,nums,0);
        return rtn;
    }

    public void backtracking(List<List<Integer>> rtn,List<Integer> list,int[] nums,int idx){
        rtn.add(new LinkedList<Integer>(list));
        for(int i = idx;i<nums.length;i++){
            list.add(nums[i]);
            backtracking(rtn,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
