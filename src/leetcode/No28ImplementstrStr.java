package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No28ImplementstrStr
 * @Description:
 * @date 2017年04月26日 下午3:21
 **/
public class No28ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int M = haystack.length();
        int N = needle.length();
        for(int i = 0;i<=M-N;i++){
            int j = 0;
            for(;j<N;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j))
                    break;
            }
            if(j==N) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "asdfasdfadf";
        String b = "lsfafjlk";
        a.indexOf(b);
    }
}
