package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liucong
 * @ClassName: leetcode.No464CanIWin
 * @Description:
 * @date 2017年04月22日 下午4:27
 **/
public class No464CanIWin {
    boolean[] visited;
    Map<Integer,Boolean> map;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum<desiredTotal) return false;
        if(desiredTotal<=0) return true;

        visited = new boolean[maxChoosableInteger+1];
        map = new HashMap<Integer,Boolean>();
        return solve(desiredTotal);
    }

    boolean solve(int desiredTotal){
        if(desiredTotal<=0)
            return false;

        int key=format(visited);
        if(!map.containsKey(key)){
            for(int i = 1;i<visited.length;i++){
                if(!visited[i]){
                    visited[i]=true;

                    if(!solve(desiredTotal-i)){
                        map.put(key,true);
                        visited[i]=false;
                        return true;
                    }

                    visited[i]=false;
                }

            }
            map.put(key,false);
        }
        return map.get(key);
    }

    int format(boolean[] visited){
        int rtn = 0;
        for(int i = 0;i<visited.length;i++){
            rtn<<=1;
            if(visited[i])
                rtn = 1|rtn;
        }
        return rtn;
    }

    public static void main(String[] args) {
        No464CanIWin test = new No464CanIWin();
        test.canIWin(3,5);
    }
}
