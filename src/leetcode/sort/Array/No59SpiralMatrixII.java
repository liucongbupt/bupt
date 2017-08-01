package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No59SpiralMatrixII
 * @Description:
 * @date 2016年12月14日 下午3:13
 **/

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 Subscribe to see which companies asked this question

 Hide Tags leetcode.Array
 Hide Similar Problems (M) Spiral Matrix

 */
public class No59SpiralMatrixII {
    public No59SpiralMatrixII() {

    }

    public int[][] generateMatrix(int n) {
        int[][] rtn = new int [n][n];
        rtn(rtn,0,n-1,0,n-1,1);
        return rtn;
    }
    public  void rtn(int[][] matrix,int x1, int x2, int y1, int y2,int num){
        if(x1>x2||y1>y2){
            return;
        }
        int m = x2-x1+1;
        if(m==1){
            for (int i = y1; i <= y2 ; i++,num++) {
                matrix[x1][i]=num;
            }
            return;
        }
        int n = y2-y1+1;
        if(n==1){
            for (int i = x1; i <= x2 ; i++,num++) {
                matrix[i][y1] = num;
            }
            return;
        }

        for (int i = y1; i <y2 ; i++,num++) {
            matrix[x1][i]=num;
        }

        for (int i = x1; i <x2 ; i++,num++) {
            matrix[i][y2]=num;
        }

        for (int i = y2; i > y1 ; i--,num++) {
            matrix[x2][i]=num;
        }

        for (int i = x2; i > x1 ; i--,num++) {
            matrix[i][y1]=num;
        }

        rtn(matrix,x1+1,x2-1,y1+1,y2-1,num);

    }
    public static void main(String[] args) {
        No59SpiralMatrixII sm = new No59SpiralMatrixII();
        int[][] rtn = sm.generateMatrix(0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(rtn[i][j]);
            }
        }
    }
}
