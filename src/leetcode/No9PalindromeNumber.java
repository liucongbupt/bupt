package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No9PalindromeNumber
 * @Description:
 * @date 2017年04月26日 上午10:01
 **/
public class No9PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int tmp = 0;
        int copyx = x;
        if(x<0)
            return false;

        while(x!=0){
            int digit = x%10;
            if (Integer.MAX_VALUE/10<tmp||Integer.MAX_VALUE/10==tmp&&Integer.MAX_VALUE%10==digit)
                return false;
            tmp = tmp*10+digit;
            x/=10;
        }
        return tmp==copyx;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(123454321));
        System.out.println(isPalindrome(876545678));
        System.out.println(isPalindrome(Integer.MIN_VALUE));
        System.out.println(isPalindrome(Integer.MAX_VALUE));
    }
}
