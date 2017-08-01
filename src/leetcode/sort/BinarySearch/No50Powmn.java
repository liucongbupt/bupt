package leetcode.sort.BinarySearch; /**
 * @author liucong
 * @ClassName: No50Powmn
 * @Description:
 * @date 2016年10月12日 4:22 PM
 **/

/**
 * Implement pow(x, n).
 */
public class No50Powmn {
    public No50Powmn() {
    }
    public double myPow(double x, int n) {
        if(n<0) return 1.0/power(x,-n);
        else return power(x,n);
    }
    public double power(double x, int n){
        if(n==0) return 1;
        double v = power(x , n/2);
        if(n%2==0) return v*v;
        else return v*v*x;

    }
    public static void main(String[] args) {

    }
}
