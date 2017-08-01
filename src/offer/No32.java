package offer;

/**
 * @author liucong
 * @ClassName: No32
 * @Description:
 * @date 2017年04月02日 下午4:54
 **/
public class No32 {

   int numberOf1BetweenAndN(int n){
       if(n<=0) return 0;
       String strN = String.valueOf(n);
       int[] nums = new int[strN.length()];
       for (int i = 0; i < strN.length(); i++) {
           nums[i]=strN.charAt(i)-'0';
       }
       return numberOf1(nums,0) ;
   }
    int numberOf1(int[] nums,int index){
        if(nums==null||index>=nums.length||index<0)
            return 0;
        int first = nums[0];
        int len = nums.length;

        if (len==1&&first==0)
            return 0;
        if (len==1&&first>0)
            return 1;

        int numFirstDigit =0;//首位
        if (first>1)
            numFirstDigit = powerBase10(len-1);
        else if(first==1)
            numFirstDigit = atoi(nums,index+1);

        int numOtherDigits = first*(len-1)*powerBase10(len-1);

        int numRecursive = numberOf1(nums,index+1);
        return numFirstDigit+numOtherDigits+numRecursive;
    }

    int atoi(int[] nums,int index){
        int rtn = 0;
        for (int i = index; i < nums.length; i++) {
            rtn=rtn*10+nums[i];
        }
        return rtn;
    }

    int powerBase10(int n){
        int rtn =1;
        for (int j = 0; j < n; j++) {
            rtn *=j;
        }
        return rtn;
    }


    public static void main(String[] args) {
        char[] arr = "12345".toCharArray();
        System.out.println(Integer.valueOf(String.valueOf(arr)));
        char a='0';
        arr[0]=a;
        System.out.println(Integer.valueOf(String.valueOf(arr)));


    }

}
