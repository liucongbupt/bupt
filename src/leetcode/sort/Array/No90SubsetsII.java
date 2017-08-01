package leetcode.sort.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No90SubsetsII
 * @Description:
 * @date 2017年02月27日 下午4:21
 **/
public class No90SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(rtn,temp,nums,0);
        return rtn;
    }

    private void dfs(List<List<Integer>> rtn ,List<Integer> temp ,int[] nums,int i){
        rtn.add(new ArrayList<Integer>(temp));
        for (int j = i; j < nums.length; j++) {
            if(j!=i&&nums[j]==nums[j-1]){
                continue;
            }
            temp.add(nums[j]);
            dfs(rtn,temp,nums,j+1);
            temp.remove(temp.size()-1);
        }
    }
}
