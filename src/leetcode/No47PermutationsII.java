package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.No47PermutationsII
 * @Description:
 * @date 2017年04月23日 下午4:15
 **/
public class No47PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rtn = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        backtracking(rtn,list,nums,new boolean[nums.length]);
        return rtn;
    }

    public void backtracking(List<List<Integer>> rtn,List<Integer> list,int[] nums,boolean[] used){
        if (list.size()==nums.length)
            rtn.add(new LinkedList<>(list));
        else{
            for (int i = 0; i < nums.length; i++) {
                if (used[i]||(i!=0&&nums[i]==nums[i-1]&&!used[i-1])) continue;
                used[i]=true;
                list.add(nums[i]);
                backtracking(rtn,list,nums,used);
                list.remove(list.size()-1);
                used[i]=false;
            }
        }
    }
}
