package offer;

/**
 * @author liucong
 * @ClassName: No14
 * @Description:
 * @date 2017年03月31日 下午2:40
 **/
public class No14 {
    public static void reorderOddEven(int[] nums){
        if(nums==null) return ;

        int start = 0;
        int end = nums.length-1;
        while (start<end){
            while (start<end&&(nums[start]&1)==1) start++;
            while (start<end&&(nums[end]&1)==0) end--;
            if (start<end){
                int temp = nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
            }

        }
    }

    public static void reorderOddEvenEx(int[] nums){
        if(nums==null) return ;

        int start = 0;
        int end = nums.length-1;
        while (start<end){
            while (start<end&&isEven(nums[start])) start++;
            while (start<end&&isEven(nums[end])) end--;
            if (start<end){
                int temp = nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
            }

        }
    }

    private static boolean isEven(int n){
        return (n&1)==1;
    }

    /**
     * 输出数组的信息
     *
     * @param arr 待输出数组
     */
    public static void printArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        reorderOddEven(array);
        printArray(array);
    }

}
