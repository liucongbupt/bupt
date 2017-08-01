package leetcode;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: leetcode.No85MaximalRectangle
 * @Description:
 * @date 2017年04月24日 上午9:32
 **/
public class No85MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        int[] height = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < n; j++) { // compute left (from left to right)
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // compute right (from right to left)
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            // compute the area of rectangle (can do this from either side)
            for (int j = 0; j < n; j++)
                max = Math.max(max, (right[j] - left[j]) * height[j]);
        }
        return max;

    }
}
