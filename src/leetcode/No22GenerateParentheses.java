package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.No22GenerateParentheses
 * @Description:
 * @date 2017年05月03日 下午4:11
 **/
public class No22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n<=0) return result;
        String str  = new String();
        dfs(result,str,n,n);
        return result;
    }
    public void dfs(List<String> res, String item, int left, int right){
        if(left>right)
            return;
        if(left==0&&right==0){
            res.add(item);
            return;
        }
        if(left>0)
            dfs(res,item+'(',left-1,right);
        if(right>0)
            dfs(res,item+')',left,right-1);
    }

//    public List<String> generateParenthesis(int n) {
//        List<String> rtn = new ArrayList<>();
//        if(n<=0) return rtn;
//        dfs(rtn,new String(),0,0,n);
//        return rtn;
//    }
//
//    public void dfs(List<String> rtn,String str,int left,int right,int max){
//        if(str.length()==max*2){
//            rtn.add(new String(str));
//            return;
//        }
//        if(left<max)
//            dfs(rtn,str+"(",left+1,right,max);
//        if(right<left)
//            dfs(rtn,str+")",left,right+1,max);
//    }
}
