package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.No46Permutations
 * @Description:
 * @date 2017年04月23日 下午4:04
 **/
public class No46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rtn = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        backtracking(rtn,list,nums,0);
        return rtn;
    }
    public void backtracking(List<List<Integer>> rtn,List<Integer> list,int[] nums,int idx){
        if (list.size()==nums.length)
            rtn.add(new LinkedList<>(list));

        for (int i = idx; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtracking(rtn,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
