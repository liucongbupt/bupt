package leetcode.sort.Array; /**
 * @author liucong
 * @ClassName: No54SpiralMatrix
 * @Description:
 * @date 2016年10月12日 3:57 PM
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * Subscribe to see which companies asked this question
 * Hide Tags leetcode.Array
 * Hide Similar Problems (M) Spiral Matrix II
 */
public class No54SpiralMatrix {

    public No54SpiralMatrix() {
    }


    public  List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rtn = new ArrayList<Integer>();
        if (matrix.length == 0 ){
           return rtn;
        }
        rtn(matrix, rtn, 0, matrix.length - 1, 0,matrix[0].length - 1);
        return rtn;
    }

    public  void rtn(int[][] matrix,List<Integer> rtn,int x1,int x2,int y1,int y2){
        if(x1>x2||y1>y2){
            return;
        }
        int m = x2-x1+1;
        if(m<=0){
            return;
        }
        if(m==1){
            for (int i = y1; i <= y2 ; i++) {
                rtn.add(matrix[x1][i]);
            }
            return;
        }
        int n = y2-y1+1;
        if(n<=0){
            return;
        }
        if(n==1){
            for (int i = x1; i <= x2 ; i++) {
                rtn.add(matrix[i][y1]);
            }
            return;
        }

        for (int i = y1; i <y2 ; i++) {
            rtn.add(matrix[x1][i]);
        }

        for (int i = x1; i <x2 ; i++) {
            rtn.add(matrix[i][y2]);
        }

        for (int i = y2; i > y1 ; i--) {
            rtn.add(matrix[x2][i]);
        }

        for (int i = x2; i > x1 ; i--) {
            rtn.add(matrix[i][y1]);
        }

        rtn(matrix,rtn,x1+1,x2-1,y1+1,y2-1);

    }



    public static void main(String[] args) {
//        leetcode.String str = null;
//        str = leetcode.String.format("Hi,%s", "王力");
//        System.out.println(str);
//        str = leetcode.String.format("Hi,%s:%s.%s", "王南", "王力", "王张");
//        System.out.println(str);
//        System.out.printf("字母a的大写是：%c %n", 'A');
//        System.out.printf("3>7的结果是：%b %n", 3 > 7);
//        System.out.printf("100的一半是：%d %n", 100 / 2);
//        System.out.printf("100的16进制数是：%x %n", 100);
//        System.out.printf("100的8进制数是：%o %n", 100);
//        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);
//        System.out.printf("上面价格的16进制数是：%a %n", 50 * 0.85);
//        System.out.printf("上面价格的指数表示：%e %n", 50 * 0.85);
//        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50 * 0.85);
//        System.out.printf("上面的折扣是%d%% %n", 85);
//        System.out.printf("字母A的散列码是：%h %n", 'A');
        No54SpiralMatrix sm = new No54SpiralMatrix();
//        List<Integer> list = sm.spiralOrder();
    }
}
