package leetcode;

import offer.No38;

/**
 * Created by liucong on 2017/5/10.
 */
public class No38CountandSay {
    public String countAndSay(int n) {
        StringBuilder rtn = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            rtn = helper(rtn.toString());
        }
        return rtn.toString();
    }

    public StringBuilder helper(String str){
        char tmp = str.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 1; i < len; i++) {
            if (str.charAt(i)!=tmp){
                sb.append(count).append(tmp);
                count=1;
                tmp = str.charAt(i);
            }else {
                count++;
            }
        }
        sb.append(count).append(tmp);
        return sb;
    }

    public static void main(String[] args) {
        No38CountandSay test = new No38CountandSay();
        test.countAndSay(2);
    }
}
