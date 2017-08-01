package offer;

/**
 * @author liucong
 * @ClassName: No54
 * @Description:
 * @date 2017年04月05日 上午9:42
 **/
public class No54 {
    static boolean isNumeric(String string){
        if (string==null)
            return false;
        int index = 0;
        if (string.charAt(index)=='+'||string.charAt(index)=='-'){
            index++;
        }
        if (index>=string.length())
            return false;
        boolean isNumeric = true;
        index = scanDigits(string,index);
        if(index<string.length()){
            if (string.charAt(index)=='.'){
                index++;
                index = scanDigits(string,index);
                if (index>=string.length()){
                    isNumeric = true;
                }else if (index<string.length()&&(string.charAt(index)=='e'||string.charAt(index)=='E')){
                    isNumeric = isExponential(string,index);
                }else {
                    isNumeric=false;
                }
            }else if (string.charAt(index)=='e'||string.charAt(index)=='E'){
                isNumeric = isExponential(string,index);
            }else {
                isNumeric=false;
            }
            return isNumeric;
        }else {
            return true;
        }


    }

    static int scanDigits(String string,int index){
        while (index<string.length()&&string.charAt(index)>='0'&&string.charAt(index)<='9'){
            index++;
        }
        return index;
    }
    static boolean isExponential(String string,int index){
        if (index>=string.length()||(string.charAt(index)!='e'&&string.charAt(index)!='E')){
            return false;
        }
        index++;

        if (index>=string.length())
            return false;
        if (string.charAt(index)=='+'||string.charAt(index)=='-'){
            index++;
        }
        if (index>=string.length())
            return false;
        index=scanDigits(string,index);
        return index>=string.length();
    }
    public static void main(String[] args) {
        System.out.println(isNumeric("100") + "[" + true + "]");
        System.out.println(isNumeric("123.45e+6") + "[" + true + "]");
        System.out.println(isNumeric("+500") + "[" + true + "]");
        System.out.println(isNumeric("5e2") + "[" + true + "]");
        System.out.println(isNumeric("3.1416") + "[" + true + "]");
        System.out.println(isNumeric("600.") + "[" + true + "]");
        System.out.println(isNumeric("-.123") + "[" + true + "]");
        System.out.println(isNumeric("-1E-16") + "[" + true + "]");
        System.out.println(isNumeric("100") + "[" + true + "]");
        System.out.println(isNumeric("1.79769313486232E+308") + "[" + true + "]");
        System.out.println();

        System.out.println(isNumeric("12e") + "[" + false + "]");
        System.out.println(isNumeric("1a3.14") + "[" + false + "]");
        System.out.println(isNumeric("1+23") + "[" + false + "]");
        System.out.println(isNumeric("1.2.3") + "[" + false + "]");
        System.out.println(isNumeric("+-5") + "[" + false + "]");
        System.out.println(isNumeric("12e+5.4") + "[" + false + "]");
    }
}
