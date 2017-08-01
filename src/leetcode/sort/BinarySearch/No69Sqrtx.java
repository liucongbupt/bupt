package leetcode.sort.BinarySearch; /**
 * @author liucong
 * @ClassName: No69Sqrtx
 * @Description:
 * @date 2016年10月12日 4:31 PM
 **/

/**
 * Implement int sqrt(int x).

 Compute and return the square root of x.

 Subscribe to see which companies asked this question

 Hide Tags Binary Search leetcode.Math
 Hide Similar Problems (M) Pow(x, n) (M) Valid Perfect Square

 */
public class No69Sqrtx {
    public No69Sqrtx() {
    }
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        while(start<=end){
            long mid = (long)(end+start)/2;
            if(mid*mid<x)
                start = (int)mid +1;
            else if(mid*mid>x)
                end = (int)mid -1;
            else
                return (int)mid;
        }
        return end;


//        if (x ==0)
//            return 0;
//        double pre;
//        double cur = 1;
//        do
//        {
//            pre = cur;
//            cur = x / (2 * pre) + pre / 2.0;
//        } while (leetcode.Math.abs(cur - pre) > 0.00001);
//        return (int)cur;
    }
    public static void main(String[] args) {
        No69Sqrtx s = new No69Sqrtx();
        int rtn = s.mySqrt(2147395599);
        System.out.println(rtn);
    }
}
