package leetcode.sort.String;

/**
 * @author liucong
 * @ClassName: No557ReverseWordsinaStringIII
 * @Description:
 * @date 2017年04月12日 下午8:42
 **/
public class No557ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        char[] data = s.toCharArray();
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
        return String.valueOf(data);
    }

    private void reverse(char[] chars,int begin,int end){
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

    public static void main(String[] args) {
        No557ReverseWordsinaStringIII test = new No557ReverseWordsinaStringIII();
        System.out.println(test.reverseWords("Let's take LeetCode contest"));
    }
}
