package offer;

/**
 * @author liucong
 * @ClassName: No49
 * @Description:
 * @date 2017年04月04日 下午6:18
 **/
public class No49 {
    public static int atoi(String str){
        if (str==null||str.length()<1)
            throw  new IllegalArgumentException(str);
        int index = 0;
        long num = 0;
        if (index<str.length()){
            boolean positive = true;
            if (str.charAt(index)=='-'){
                positive=false;
            }
            index++;

            if (index<str.length()){
                num = parseString(str,1,positive);
            }
        }
        return (int)num;

    }

    private static long parseString(String str,int index,boolean positive){
        if (index>=str.length())
            throw new NumberFormatException(str);
        long num = 0;
        while (index<str.length()){
            if (isDigit(str.charAt(index))){
                int flag = positive?1:-1;
                num = num*10+flag*(str.charAt(index)-'0');
                if (num>Integer.MAX_VALUE||num<Integer.MIN_VALUE){
                    throw new NumberFormatException(str);
                }
                index++;
            }else{
                throw new NumberFormatException(str);
            }
        }
        return num;
    }

    private static boolean isDigit(char c){
        return c>='0'&&c<='9';
    }

    public static void main(String[] args) {
//        System.out.println(atoi("123"));
//        System.out.println(atoi("+123"));
        System.out.println(atoi("-123"));
//        System.out.println(atoi("1a123"));
        System.out.println(atoi("+2147483647"));
        System.out.println(atoi("-2147483648"));
        System.out.println(atoi("+2147483648"));
        System.out.println(atoi("-2147483648"));
    }
}
