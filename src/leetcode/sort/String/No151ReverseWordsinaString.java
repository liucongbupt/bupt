package leetcode.sort.String;

/**
 * @author liucong
 * @ClassName: No151ReverseWordsinaString
 * @Description:
 * @date 2017年04月12日 下午8:59
 **/
public class No151ReverseWordsinaString {


    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];

    }


    public static void main(String[] args) {
        No151ReverseWordsinaString test = new No151ReverseWordsinaString();
//        System.out.println(test.reverseWords("   the sky is blue  "));
        System.out.println(test.reverseWords(" "));
//        System.out.println("abc".substring(0,0));
    }
}
