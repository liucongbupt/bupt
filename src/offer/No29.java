package offer;

/**
 * @author liucong
 * @ClassName: No29
 * @Description:
 * @date 2017年04月01日 下午11:10
 **/
public class No29 {


    public static int moreThanHalfNumEx(int[] nums){
        if (!checkValidArray(nums))
            return 0;
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if(times==0){
                result = nums[i];
                times=1;
            }else if(nums[i]==result){
                times++;
            }else {
                times--;
            }
        }
        if(!checkMoreThanHalf(nums,result))
            return 0;
        return result;
    }


    public static int moreThanHalfNum(int[] nums){
        if (!checkValidArray(nums))
            return 0;
        int middle = nums.length>>1;
        int start = 0;
        int end = nums.length-1;
        int index = partition(nums,start,end);
        while (index!=middle){
            if(index>middle){
                end =index-1;
            }else{
                start=index+1;
            }
            index = partition(nums,start,end);
        }
        if(!checkMoreThanHalf(nums,nums[middle]))
            return 0;
        return nums[index];
    }
    public static boolean checkValidArray(int[] nums){
        if(nums==null||nums.length<=0)
            return false;
        return true;
    }
    public static boolean checkMoreThanHalf(int[] nums,int number){
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==number)
                times++;
        }
        return times>(nums.length/2)?true:false;
    }

    private static int partition(int[] nums,int start,int end){
        int tmp = nums[start];

        while (start<end){
            while (start<end&&nums[end]>=tmp) end--;
            nums[start]=nums[end];
            while (start<end&&nums[start]<=tmp) start++;
            nums[end]=nums[start];
        }
        nums[start] = tmp;
        return start;
    }
    public static void swap(int[] str,int i,int j){
        int temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


    public static void main(String[] args) {
        int[] a = {1,2,2,2,4,2,6};
        int[] b = {0,1,2,3,4,5};
        int[] c = {5};
        int[] d={};
        int[] e={4,5};
        int[] f={5,5};
        System.out.println(moreThanHalfNum(a));
        System.out.println(moreThanHalfNum(b));
        System.out.println(moreThanHalfNum(c));
        System.out.println(moreThanHalfNum(d));
        System.out.println(moreThanHalfNum(e));
        System.out.println(moreThanHalfNum(f));
    }
}
