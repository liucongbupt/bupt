package leetcode;

/**
 * Created by liucong on 2017/5/10.
 */
public class No396RotateFunction {
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int temp = 0;
        int sum = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            temp+=(i*A[i]);
            sum+=A[i];
        }
        max = Math.max(max,temp);
        for (int i = 1; i < n; i++) {
            temp = temp + sum - n*A[n-i];
            max = Math.max(temp,max);
        }
        return max;
    }
}
