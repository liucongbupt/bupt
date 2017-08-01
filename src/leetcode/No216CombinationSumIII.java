package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.No216CombinationSumIII
 * @Description:
 * @date 2017年04月20日 下午3:10
 **/
public class No216CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new LinkedList<>();
        backtrack(list,new ArrayList<Integer>(),n,k,1);
        return list;
    }

    public void backtrack(List<List<Integer>> list,List<Integer> cur,int target,int k,int idx){
        if(k<0||target<0){
            return;
        }else if(k==0&&target==0){
            list.add(new ArrayList<Integer>(cur));
            return;
        }else{
            for(int i = idx;i<10;i++){
                cur.add(i);
                backtrack(list,cur,target-i,k-1,i+1);
                cur.remove(cur.size()-1);
            }
        }
    }
}
