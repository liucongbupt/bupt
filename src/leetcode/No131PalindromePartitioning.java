package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.No131PalindromePartitioning
 * @Description:
 * @date 2017年04月23日 下午4:32
 **/
public class No131PalindromePartitioning {




    public List<List<String>> partition(String s) {
        List<List<String>> rtn = new LinkedList<>();
        List<String> list =  new LinkedList<>();
        backTracking(rtn,list,s,0);
        return rtn;
    }
    public void backTracking(List<List<String>> rtn,List<String> list,String s,int idx){
        if(idx==s.length())
            rtn.add(new LinkedList<>(list));
        else{
            for(int i = idx;i<s.length();i++){
                if(isPalindrome(s,idx,i)){
                    list.add(s.substring(idx,i+1));
                    backTracking(rtn,list,s,i+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    public boolean isPalindrome(String s,int low,int high){
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}
