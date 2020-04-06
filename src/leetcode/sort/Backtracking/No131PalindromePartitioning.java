package leetcode.sort.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No131PalindromePartitioning
 * @Description:
 * @date 2017年04月10日 下午5:53
 **/
public class No131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> rtn = new ArrayList<>();
        backTracking(rtn,new ArrayList<String>(),s,0);
        return rtn;
    }
    public void backTracking(List<List<String>> rtn,List<String> str,String s,int idx){
        if (idx==s.length()){
            rtn.add(new ArrayList<>(str));
        }

        for (int i = idx; i <s.length() ; i++) {
            if (isPalindrome(s,idx,i)){
                str.add(s.substring(idx,i+1));
                backTracking(rtn,str,s,i+1);
                str.remove(str.size()-1);

            }
        }
    }
    public boolean isPalindrome(String s,int low,int high){
        while (low<high)
            if (s.charAt(low++)!=s.charAt(high--)) return false;
        return true;
    }
}
