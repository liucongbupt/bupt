package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No74Searcha2DMatrix
 * @Description:
 * @date 2017年02月27日 上午10:57
 **/

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.

 Subscribe to see which companies asked this question.

 Show Tags
 Show Similar Problems

 */
public class No74Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int temp = -1;

        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }

        if(target<matrix[0][0]){
            return false;
        }

        if(target>matrix[matrix.length-1][0]){
            temp = matrix.length-1;
        }else{
            for (int i = 0; i < matrix.length; i++) {

                if(matrix[i][0]==target){
                    return true;
                }

                if(target>matrix[i][0]&&target<matrix[i+1][0]){
                    temp = i;
                }

            }
        }



        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[temp][i]==target){
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrixx(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m*n-1;

        while(start<=end){
            int mid=(start+end)/2;
            int midX=mid/n;
            int midY=mid%n;

            if(matrix[midX][midY]==target)
                return true;

            if(matrix[midX][midY]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return false;
    }
}
