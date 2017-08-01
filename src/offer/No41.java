package offer;

/**
 * @author liucong
 * @ClassName: No41
 * @Description:
 * @date 2017年04月03日 下午2:59
 **/
public class No41 {
    void findContinuousSequence(int sum){
        if (sum<3)
            return;

        int small = 1;
        int big = 2;
        int mid = (sum+1)/2;
        int curSum = small+big;
        while (small<mid){
            if (curSum==sum){
                printSum(small,big);
                big++;
                curSum+=big;
            }else if (curSum<sum){
                big++;
                curSum+=big;
            }else {
                curSum-=small;
                small++;
            }
        }
    }

    void printSum(int small,int big){
        for (int i = small; i <= big; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    boolean findNumbersWithSum(int[] data,int sum){
        boolean find = false;
        if(data==null||data.length<0)
            return find;
        int[] rtn = new int[2];
        int start = 0;
        int end = data.length-1;
        while (start<end){
            int curSum = data[start]+data[end];
            if (curSum==sum){
                rtn[0]=data[start];
                rtn[1]=data[end];
                find = true;
                break;
            }else if (curSum<sum){
                start++;
            }else {
                end--;
            }
        }
        return find;
    }


    public static void main(String[] args) {
        No41 test =  new No41();
        test.findContinuousSequence(3);
        System.out.println("********");
        test.findContinuousSequence(9);
        System.out.println("********");
    }
}
