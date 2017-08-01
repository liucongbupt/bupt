package leetcode;

import java.util.HashMap;

/**
 * @author liucong
 * @ClassName: leetcode.No447NumberofBoomerangs
 * @Description:
 * @date 2017年03月27日 下午3:50
 **/
public class No447NumberofBoomerangs {
    private int getDistance(int[] a,int[] b){
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
    public int numberOfBoomerangs(int[][] points) {
        int rtn = 0;
        HashMap<Integer,Integer> map  =  new HashMap<>();
        for (int[] i:points
             ) {
            for (int[] j:points
                 ) {
                if(i==j) continue;
                map.put(getDistance(i,j),map.getOrDefault(getDistance(i,j),0)+1);
            }

            for (int val:map.values()
                 ) {
                rtn+=val*(val-1);
            }
            map.clear();
        }
        return rtn;
    }
}
