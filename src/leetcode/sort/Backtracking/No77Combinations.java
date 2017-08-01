package leetcode.sort.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No77Combinations
 * @Description:
 * @date 2017年04月10日 下午4:51
 **/
public class No77Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), 0, n, k);
        return result;
    }
    public static void getResult(List<List<Integer>> rtn,List<Integer> list,int start,int n,int target){
        if (0==target){
            rtn.add(new ArrayList<>(list));
        }else{
            for (int i = start+1; i <=n ; i++) {
                list.add(i);
                getResult(rtn,list,i,n,target-1);
                list.remove(list.size()-1);
            }
        }
    }
//    public static List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> combs = new ArrayList<List<Integer>>();
//        combine(combs, new ArrayList<Integer>(), 1, n, k);
//        return combs;
//    }
//    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
//        if(k==0) {
//            combs.add(new ArrayList<Integer>(comb));
//            return;
//        }
//        for(int i=start;i<=n;i++) {
//            comb.add(i);
//            combine(combs, comb, i+1, n, k-1);
//            comb.remove(comb.size()-1);
//        }
//    }
    public static void main(String[] args) {
        combine(20,16);
    }
}
