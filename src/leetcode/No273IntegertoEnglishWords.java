package leetcode;

/**
 * Created by liucong on 2017/5/9.
 */
public class No273IntegertoEnglishWords {
    String[] LESS_THAN_TENS = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] TENS = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] THOUSANDS = {"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if (num==0)
            return "Zero";
        int i = 0;
        String rtn = "";
        while (num!=0){
            if (num%1000!=0){
                rtn = helper(num%1000)+ THOUSANDS[i]+" "+rtn;
            }
            num/=1000;
            i++;
        }
        return rtn.trim();
    }

    public String helper(int num){
        if(num==0){
            return "";
        }if(num<20){
            return LESS_THAN_TENS[num]+" ";
        }else if(num<100) {
            return TENS[num/10]+" "+helper(num%10);
        }else {
            return LESS_THAN_TENS[num/100]+" Hundred "+helper(num%100);
        }
    }
}
