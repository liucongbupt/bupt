package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No73SetMatrixZeroes
 * @Description:
 * @date 2017年02月27日 上午10:14
 **/

/**
 * Total Accepted: 92842
 Total Submissions: 262777
 Difficulty: Medium
 Contributors: Admin
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 click to show follow up.

 Follow up:
 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?

 Subscribe to see which companies asked this question.

 Hide Tags leetcode.Array
 Hide Similar Problems (M) Game of Life

 */
public class No73SetMatrixZeroes {
    //step1 标记第一行第一列是否置零
    //step2 用第一行第一列标记其余行列是否置零
    //step3 置零
    //step4 第一行第一列置零
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0)
            return;

        boolean first_row = false;
        boolean first_col = false;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if(matrix[i][0]==0){
                first_col=true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if(matrix[0][i]==0){
                first_row=true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }

        if(first_col==true) {
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;
            }
        }
        if(first_row==true){
            for (int i = 0; i < n; i++) {
                matrix[0][i]=0;
            }
        }
        return;
    }
}
