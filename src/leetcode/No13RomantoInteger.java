package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No13RomantoInteger
 * @Description:
 * @date 2017年04月26日 上午10:12
 **/
public class No13RomantoInteger {
    public int romanToInt(String s) {
        char[] arr =s.toCharArray();
        int rtn = toNumber(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(toNumber(arr[i])>toNumber(arr[i-1])){
                rtn+=toNumber(arr[i])-2*toNumber(arr[i-1]);
            }else{
                rtn+=toNumber(arr[i]);
            }
        }
        return rtn;
    }
    public int toNumber(char ch){
        switch (ch) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                break;
        }
        return 0;
    }
}
