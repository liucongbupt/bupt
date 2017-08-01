package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No48RotateImage
 * @Description:顺时针 上下 对角  逆时针 左右 对角
 * @date 2017年04月27日 下午11:09
 **/
public class No48RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m/2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[m-1-i];
            matrix[m-1-i] = tmp;
        }

        for (int i = 0; i < m ; i++) {
            for (int j = i+1; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
