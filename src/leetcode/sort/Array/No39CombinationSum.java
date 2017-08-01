package leetcode.sort.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liucong on 9/29/16.
 */

/**
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ] */
public class No39CombinationSum {
    public No39CombinationSum() {
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if(candidates==null||candidates.length==0){
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        dfs(result,cur,candidates,target,0);
        return result;
    }

    public void dfs(List<List<Integer>> result,List<Integer> cur,int[] cadidates,int target,int start){
        if(target<0)
            return;
        if(target==0){
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < cadidates.length; i++) {

            if(i>0&&cadidates[i]==cadidates[i-1])continue;
            cur.add(cadidates[i]);
                dfs(result,cur,cadidates,target-cadidates[i],i);
                cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {

    }
}

