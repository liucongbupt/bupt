package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No8StringtoIntegeratoi
 * @Description:
 * @date 2017年04月25日 下午9:26
 **/
public class No8StringtoIntegeratoi {
    public static int myAtoi(String str) {
        int index = 0,sign = 1,total = 0;

        if (str.length() == 0)
            return 0;

        while (str.charAt(index)==' '&&index<str.length()){
            index++;
        }

        if (str.charAt(index)=='+'||str.charAt(index)=='-'){
            sign = str.charAt(index)=='+'?1:-1;
            index++;
        }

        while (index<str.length()){
            int digit = str.charAt(index)-'0';
            if (digit<0||digit>9) break;

            if (Integer.MAX_VALUE/10<total||Integer.MAX_VALUE/10==total&&Integer.MAX_VALUE%10==digit){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            total = 10*total+digit;
            index++;
        }
        return total*sign;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("-1234"));
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("-21474-qq"));
        System.out.println(myAtoi("-21474-1"));
        System.out.println(myAtoi("+1"));
    }
}
