package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No62UniquePaths
 * @Description:
 * @date 2016年12月28日 下午2:52
 **/

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 */
public class No62UniquePaths {

    public No62UniquePaths() {

    }

    public static int uniquePaths(int m, int n) {
        int[][] v = new int[m][n];
        if (m == 0 || n == 0) return 0;
        if (n == 1 || m == 1) return 1;
        for (int i = 0; i < m; i++) {
            v[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            v[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                v[i][j] = v[i - 1][j] + v[i][j - 1];
            }
        }
        return v[m - 1][n - 1];
    }


    public long cal_factorial(int end, int start){
        long rtn = 1;
        while(end>=start){
            rtn *= end;
            end--;
        }
        return rtn;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 2));
    }
}
