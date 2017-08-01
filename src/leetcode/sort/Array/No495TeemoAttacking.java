package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No495TeemoAttacking
 * @Description:
 * @date 2017年03月01日 下午10:22
 **/

/**
 *
 */
public class No495TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int rtn =0;
        if(timeSeries.length==0) return rtn;
        if(timeSeries.length==1) return duration;
        rtn=duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if((duration+timeSeries[i-1])<=timeSeries[i]){
                rtn+=duration;
            }else{
                rtn = rtn + timeSeries[i] - timeSeries[i-1];
            }

        }

        return rtn;
    }

    public static void main(String[] args) {
        No495TeemoAttacking s= new No495TeemoAttacking();
       int n= s.findPoisonedDuration(new int[]{1,4,5},2);
        System.out.println(n);
    }
}
