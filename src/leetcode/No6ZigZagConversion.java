package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No6ZigZagConversion
 * @Description:
 * @date 2017年04月25日 下午9:46
 **/
public class No6ZigZagConversion {
    public static String convert(String s, int numRows) {
        if(numRows==1) return s;
        String rtn  = "";
        for(int i = 0;i<numRows;i++){
            int tmp = i;
            if(i==0||i==numRows-1){
                while(tmp<s.length()){
                    rtn+=s.charAt(tmp);
                    tmp+=(numRows-1)*2;
                }
            }else{
                int interval = (numRows-1)*2;
                int jump = (numRows-(i+1))*2;
                while(tmp<s.length()){
                    rtn+=s.charAt(tmp);
                    tmp+=jump;
                    jump=interval-jump;
                }
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        System.out.println(convert("ABCDE",4));
        System.out.println("PAHNAPLSIIGYIR");
    }
}
