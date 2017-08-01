package leetcode.sort.Math;

/**
 * @author liucong
 * @ClassName: No415AddStrings
 * @Description:
 * @date 2016年11月22日 上午11:12
 **/

/**
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 Subscribe to see which companies asked this question

 Hide Tags leetcode.Math
 Hide Similar Problems (M) Add Two Numbers (M) Multiply Strings

 */
public class No415AddStrings {
    public No415AddStrings() {

    }

    public String addStrings(String num1, String num2) {
        StringBuffer sb=new StringBuffer();
        int l1=num1.length();
        int l2=num2.length();
        char[] c1=num1.toCharArray();
        char[] c2=num2.toCharArray();

        int carry=0;

        for (int i = 0; i <l1||i<l2; i++) {

            int a1=i<l1?c1[l1-1-i]-48:0;

            int a2=i<l2?c2[l2-1-i]-48:0;

            int ans=a1+a2+carry;

            sb.append(ans%10);
            carry=ans/10;
        }

        if (carry==1) {
            sb.append("1");
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {

    }
}
