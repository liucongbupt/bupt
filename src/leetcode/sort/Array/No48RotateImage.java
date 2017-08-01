package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: leetcode.Array.No48RotateImage
 * @Description:
 * @date 2016年10月05日 3:46 PM
 **/
public class No48RotateImage {
    public No48RotateImage() {
    }
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int length = matrix.length;

        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < (length + 1) / 2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length -j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {

    }
}
