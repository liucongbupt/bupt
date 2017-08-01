package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No12IntegertoRoman
 * @Description:
 * @date 2017年04月25日 下午11:06
 **/
public class No12IntegertoRoman {
    public String intToRoman(int num) {
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String str="";
        for (int i = 0; num!=0 ; i++) {
            while (num>val[i]){
                num-=val[i];
                str+=symbol[i];
            }
        }
        return str;
    }
}
