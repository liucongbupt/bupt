package leetcode.sort.String;

/**
 * @author liucong
 * @ClassName: No459RepeatedSubstringPattern
 * @Description:
 * @date 2017年04月12日 下午8:34
 **/
public class No459RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <=s.length()/2 ; i++) {
            String temp = s.substring(0,i);
            if (s.length()%temp.length()==0){
                int k = s.length()/temp.length();
                StringBuilder sb = new StringBuilder();
                while (k--!=0){
                    sb.append(temp);
                }
                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
    }
}
