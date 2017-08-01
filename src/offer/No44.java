package offer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: No44
 * @Description:
 * @date 2017年04月04日 下午3:42
 **/
public class No44 {
    static boolean isContinuous(int[] nums){
        if (nums==null||nums.length<1){
            return false;
        }

        Arrays.sort(nums);

        int numOfZero = 0;
        int numOfGap = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0)
                numOfZero++;
        }

        int small = numOfZero;
        int big = small+1;
        while (big<nums.length){
            if (nums[small]==nums[big])
                return false;

            numOfGap += nums[big]-nums[small]-1;
            small=big;
            big++;
        }

        return numOfGap<=numOfZero;
    }
    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 2, 5, 4};
        System.out.println("1"+isContinuous(numbers1));
        int[] numbers2 = {1, 3, 2, 6, 4};
        System.out.println("2"+isContinuous(numbers2));
        int[] numbers3 = {0, 3, 2, 6, 4};
        System.out.println("3"+isContinuous(numbers3));
        int[] numbers4 = {0, 3, 1, 6, 4};
        System.out.println("4"+isContinuous(numbers4));
        int[] numbers5 = {1, 3, 0, 5, 0};
        System.out.println("5"+isContinuous(numbers5));
        int[] numbers6 = {1, 3, 0, 7, 0};
        System.out.println("6"+isContinuous(numbers6));
        int[] numbers7 = {1, 0, 0, 5, 0};
        System.out.println("7"+isContinuous(numbers7));
        int[] numbers8 = {1, 0, 0, 7, 0};
        System.out.println("8"+isContinuous(numbers8));
        int[] numbers9 = {3, 0, 0, 0, 0};
        System.out.println("9"+isContinuous(numbers9));
        int[] numbers10 = {0, 0, 0, 0, 0};
        System.out.println("10"+isContinuous(numbers10));
        int[] numbers11 = {1, 0, 0, 1, 0};
        System.out.println("11"+isContinuous(numbers11));


    }
}
