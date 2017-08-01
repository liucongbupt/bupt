package leetcode.sort.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No78Subsets
 * @Description:
 * @date 2017年02月27日 下午3:41
 **/
public class No78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(rtn,temp,nums,0);
        return rtn;
    }

    private void dfs(List<List<Integer>> rtn ,List<Integer> temp ,int[] nums,int i){
        rtn.add(new ArrayList<Integer>(temp));
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            dfs(rtn,temp,nums,j+1);
            temp.remove(temp.size()-1);
        }
    }



    public List<List<Integer>> subsetss(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        res.add(new ArrayList<Integer>());
//        for (int num : nums) {  // ①从数组中取出每个元素
//            int size = res.size();
//            for (int i = 0; i < size; i++) {
//                List<Integer> temp = new ArrayList<>(res.get(i));  // ②逐一取出中间结果集
//                temp.add(num);  // ③将 num 放入中间结果集
//                res.add(temp);  // ④加入到结果集中
//            }
//        }
//        return res;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int num:nums
             ) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<Integer>(res.get(i));
                temp.add(num);
                res.add(temp);
            }

        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        No78Subsets s = new No78Subsets();
        s.subsets(nums);
    }
}
