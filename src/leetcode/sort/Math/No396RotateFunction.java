package leetcode.sort.Math; /**
 * @author liucong
 * @ClassName: leetcode.Math.No396RotateFunction
 * @Description:
 * @date 2016年11月21日 下午4:42
 **/

/**
 * Given an array of integers A and let n to be its length.
 * <p>
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 * <p>
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * <p>
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * <p>
 * Note:
 * n is guaranteed to be less than 105.
 * <p>
 * Example:
 * <p>
 * A = [4, 3, 2, 6]
 * <p>
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * <p>
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags leetcode.Math
 * F(i) = F(i-1) + sum - n*A[n-i]
 */
public class No396RotateFunction {
    public No396RotateFunction() {
    }
//    public int maxRotateFunction(int[] A) {
//        Queue<Integer> queue = new leetcode.LinkedList<Integer>();
//        if(A==null) return 0;
//        for (int i = 0; i < A.length; i++) {
//            queue.add(A[i]);
//        }
//
//        int n = A.length;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            Queue<Integer> queueb = new leetcode.LinkedList<Integer>();
//            for (Integer j: queue
//                    ) {
//                queueb.add(j);
//            }
//            int temp = 0;
//            for (int k = 0; k < n; k++) {
//                temp+= (k*(queueb.poll()));
//            }
//            if(temp>=max){
//                max=temp;
//            }
//            Integer a = queue.poll();
//            queue.add(a);
//        }
//
//        return max;
//    }


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

    public static void main(String[] args) {
        No396RotateFunction rf = new No396RotateFunction();
        System.out.println(rf.maxRotateFunction(new int[]{4, 3, 2, 6}));
    }
}
