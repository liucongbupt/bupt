package leetcode;

/**
 * Created by liucong on 2017/5/9.
 */
public class No29DivideTwoIntegers {
    public static  int divide(int dividend, int divisor) {
        if (divisor==0||(divisor==-1&&dividend==Integer.MIN_VALUE))
            return Integer.MAX_VALUE;

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        int ans = 0;

        long dvd = dividend>0?dividend:-(long)dividend;
        long dvs = divisor>0?divisor:-(long)divisor;
        while (dvd>=dvs){
            long a = dvs;
            long m = 1;
            while ((a<<1)<dvd){
                m<<=1;
                a<<=1;
            }
            ans+=m;
            dvd-=a;
        }
        return sign==1?ans:-ans;
    }

    public static void main(String[] args) {
        System.out.println(divide(Integer.MIN_VALUE,1));
    }
}
