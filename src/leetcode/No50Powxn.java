package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No50Powxn
 * @Description:
 * @date 2017年04月27日 下午10:24
 **/
public class No50Powxn {


    public double pow(double x, int n) {
        if (x==0)
            return 0;
        if(n == 0)
            return 1;
        if(n<0){
            if (n==Integer.MIN_VALUE){
                n  = Integer.MAX_VALUE;
            }else {
                n = - n;
            }
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }


    public double myPow(double x, int n) {

        if (x == 0 && n == 0) {
            throw new RuntimeException("invalid input. base and exponent both are zero");
        }

        if(n==0)
            return 1;

        long e = n;
        if(e<0){
            e = -e;
        }

        double rtn = powUnsign(x,e);

        if(n<0){
            rtn = 1/rtn;
        }

        return rtn;

    }

    public double powUnsign(double x,long n){
        if(n==0)
            return 1;
        if(n==1)
            return x;

        double rtn = powUnsign(x,n>>1);
        rtn *= rtn;

        if(n%2==1){
            rtn *= x;
        }
        return rtn;
    }
}
