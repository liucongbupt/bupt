package leetcode.sort.Math;

/**
 * @author liucong
 * @ClassName: leetcode.Math.No43MultiplyStrings
 * @Description:
 * @date 2016年09月30日 4:28 PM
 **/
public class No43MultiplyStrings {
    public No43MultiplyStrings() {
    }

    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        String max=null;
        String min=null;
        StringBuffer rtn = new StringBuffer();
        min=(num1.length()>=num2.length()?num2:num1);
        max=(num1.length()>=num2.length()?num1:num2);
        max=reverse(max);
        min=reverse(min);

        for (int i = 0; i < min.length(); i++) {
            int carry = 0;
            int count = i;
            StringBuffer rtnCons = new StringBuffer();
            while(count>0){
                rtnCons.append('0');
                count--;
            }
            for (int j = 0; j < max.length(); j++) {
                int temp = (min.charAt(i)-'0')*(max.charAt(j)-'0')+carry;
                if(temp>9){
                    carry=temp/10;
                    temp-=(carry*10);
                }else{
                    carry=0;
                }
                rtnCons.append((char)(temp+48));
            }
            if(carry!=0){
                rtnCons.append(carry);
            }

            rtn = add(rtn.toString(),rtnCons.reverse().toString());
        }
        return rtn.toString();
    }

    public StringBuffer add(String num1, String num2) {
        if(num1==null) return new StringBuffer(num2);
        if(num2==null) return new StringBuffer(num1);

        String max=null;
        String min=null;
        StringBuffer rtn = new StringBuffer();
        min=(num1.length()>=num2.length()?num2:num1);
        max=(num1.length()>=num2.length()?num1:num2);
        max=reverse(max);
        min=reverse(min);
        int carry=0;
        for (int i = 0; i < min.length(); i++) {
            int temp=(min.charAt(i)-'0')+(max.charAt(i)-'0')+carry;
            if(temp>9){
                temp-=10;
                carry=1;
            }else{
                carry=0;
            }
            rtn.append((char)(temp+48));
        }
        for (int i = min.length(); i < max.length(); i++) {
            if(carry!=0){
                int temp=(max.charAt(i)-'0')+carry;
                if(temp>9){
                    temp-=10;
                    carry=1;
                }else{
                    carry=0;
                }
                rtn.append((char)(temp+48));
            }else{
                rtn.append(max.charAt(i));
            }

        }
        if(carry!=0)
            rtn.append(1);
        rtn.reverse();
        return rtn;
    }
    public String reverse(String str){
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        return sb.toString();

    }

    public static void main(String[] args) {
        No43MultiplyStrings ms = new No43MultiplyStrings();
        System.out.println(ms.multiply("9133","0"));
    }
}
