package leetcode.sort.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liucong on 9/29/16.
 */

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class No40CombinationSumII {
    public No40CombinationSumII() {
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        back_tracking(rtn, new ArrayList<>(),candidates,target,0);
        return rtn;
    }
    public void back_tracking(List<List<Integer>> result,List<Integer> cur,int[] candidates,int target,int start){
        for (int i = start; i < candidates.length && candidates[i]<=target; i++) {
            if(target>0){
                cur.add(candidates[i]);
                back_tracking(result, cur, candidates, target-candidates[i], i++);
                cur.remove(cur.size()-1);
            }else if(target==0){
                if(!result.contains(cur))
                    result.add(cur);
            }
        }
    }
    public static void main(String[] args) {
        No40CombinationSumII a = new No40CombinationSumII();
        int[] test = new int[]{1,2,1,5,6,7,10};
        List<List<Integer>> rtn = a.combinationSum2(test,8);
    }
}
