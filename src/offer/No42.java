package offer;

/**
 * @author liucong
 * @ClassName: No42
 * @Description:
 * @date 2017年04月03日 下午2:59
 **/
public class No42 {
    void reverse(char[] chars,int begin,int end){
        if (chars==null||chars.length<1||begin<0||end>chars.length||begin>end)
            return;
        while (begin<end){
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }
    char[] reverseSentence(char[] data){
        if (data==null)
            return null;
        reverse(data,0,data.length-1);
        int begin = 0;
        int end = 0;
        while (begin<data.length){
            if (data[begin]==' '){
                begin++;
                end++;
            }else if(end==data.length||data[end]==' '){
                reverse(data,begin,end-1);
                end++;
                begin=end;
            }else {
                end++;
            }
        }
        return data;
    }

    char[] leftRotateString(char[] str,int n){
        if (str==null||str.length<1){
            return null;
        }

        reverse(str,0,n-1);
        reverse(str,n,str.length-1);
        reverse(str,0,str.length-1);
        return str;
    }

    public static void main(String[] args) {
        No42 test = new No42();
        char[] str = "abcdefg".toCharArray();
        str = test.leftRotateString(str,2);
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
    }
}
