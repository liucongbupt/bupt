package leetcode.sort.Math;

/**
 * Created by liucong on 9/26/16.
 */
public class No29DivideTwoIntegers {
    
    public No29DivideTwoIntegers() {
    }

    public int divide(int dividend, int divisor) {
        if(divisor==0){
            return dividend>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        if(dividend==0){
            return 0;
        }
        if(dividend==Integer.MAX_VALUE&&divisor==-1){
            return 0;
        }
        boolean isNegative =(dividend < 0 && divisor > 0) ||
                (dividend > 0 && divisor < 0);
        long a = Math.abs(dividend);
        long b = Math.abs(divisor);
        int rtn = 0;
        while(a>=b){
            int temp = 0;
            while(a>=(b<<temp)){
                temp++;
            }
            a-=b<<(temp-1);
            rtn+=(1<<(temp-1));
        }
        return isNegative?-rtn:rtn;
    }

    public static void main(String[] args) {
        No29DivideTwoIntegers a = new No29DivideTwoIntegers();
        System.out.println(a.divide(Integer.MIN_VALUE,1));
    }
}
