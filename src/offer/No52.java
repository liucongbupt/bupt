package offer;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: No52
 * @Description:
 * @date 2017年04月04日 下午8:25
 **/
public class No52 {
    static double[] multiply(double[] array){
        if (array==null||array.length<1)
            throw  new IllegalArgumentException("Bad Input");
        double[] rtn = new double[array.length];
        rtn[0]=1;
        for (int i = 1; i < array.length; i++) {
            rtn[i]=rtn[i-1]*array[i-1];
        }
        int tmp = 1;
        for (int i = array.length-2; i >=0 ; i--) {
            tmp*=array[i+1];
            rtn[i]*=tmp;
        }
        return rtn;
    }

    public static void main(String[] args) {
        double[] array1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(multiply(array1))); // double expected[] = {120, 60, 40, 30, 24};
        double[] array2 = {1, 2, 0, 4, 5};
        System.out.println(Arrays.toString(multiply(array2))); // double expected[] = {0, 0, 40, 0, 0};
        double[] array3 = {1, 2, 0, 4, 0};
        System.out.println(Arrays.toString(multiply(array3))); // double expected[] = {0, 0, 0, 0, 0};
        double[] array4 = {1, -2, 3, -4, 5};
        System.out.println(Arrays.toString(multiply(array4))); // double expected[] = {120, -60, 40, -30, 24};
        double[] array5 = {1, -2};
        System.out.println(Arrays.toString(multiply(array5))); // double expected[] = {-2, 1};
    }
}
