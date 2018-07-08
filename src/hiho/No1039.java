package hiho;

import java.util.*;

/**
 * @author liucong
 * @ClassName: No1039
 * @Description:字符消除
 * @date 2017年03月30日 下午2:29
 **/
public class No1039 {
    private static void earase(String sb) {
        int res = 0;
        int max = Integer.MAX_VALUE;
        char[] change = {'A', 'B', 'C'};
        StringBuilder input = new StringBuilder(sb);
        StringBuilder output = new StringBuilder();
        StringBuilder output = new StringBuilder();
        StringBuilder output = new StringBuilder();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < input.length() + 1; j++) {
                if (i == 0) {
                    output.append(change[i]).append(input);
                } else if (i == input.length()) {
                    output.append(input).append(change[i]);
                } else {
                    output.append(input.subSequence(0, i)).append(change[i]).append(input.subSequence(i, input.length()));
                }
                res = earase2(output);
                max = res > max ? res : max;
            }
        }
        System.out.println(res);
    }

    //    private static int earse(leetcode.String sb) {
//        boolean earse = true;
//        int m = sb.length();
//        char c='0';
//        StringBuilder temp = new StringBuilder();
//        while (earse) {
//            earse=false;
//            for (int i = 0; i < sb.length()-1; i++) {
//                if (sb.charAt(i) != sb.charAt(i + 1)) {
//                    if (c == sb.charAt(i)) {
//                        continue;
//                    }
//                    temp.append(sb.charAt(i));
//                    if(i==sb.length()-2) temp.append(sb.charAt(i+1));
//                } else {
//                    earse = true;
//                    c = sb.charAt(i);
//                }
//            }
//            if (temp.length()!=0){
//                sb = temp.toString();
//            }
//            temp.delete( 0, temp.length() );
//            c='0';
//        }
//
//        return m-sb.length();
//    }
    private static int earase2(StringBuilder cArray) {
        if (cArray.length() <= 1) {
            return 0;
        }
        int res = 0;
        StringBuilder nChar = new StringBuilder();
        for (int i = 0; i < cArray.length(); i++) {
            int cnt = 1;
            while (i < cArray.length() - 1 && cArray.charAt(i + 1) == cArray.charAt(i)) {
                i++;
                cnt++;
            }
            if (cnt == 1) {
                // 使用正向添加，不是反向删除，速度略有加快
                nChar.append(cArray.charAt(i));
            } else {
                res += cnt;
            }
        }
        if (cArray.length() - nChar.length() > 0
                && nChar.length() >= 2) {
            return res + earase2(nChar);
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int N = sin.nextInt();
        while (N-- != 0) {
            String P = sin.next();
            earase(P);
        }
    }
}
