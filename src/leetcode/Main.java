package leetcode;

import java.util.*;

public class Main {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int mod = in.nextInt();
        String str = in.next();
        String[] strs  = new String[4];
        strs = str.split(":");


        if(mod==0){
            strs = zip(strs);
        }else if (mod==1){
            strs = unzip(strs);
        }

        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i]);
            if (i!= strs.length-1)
                System.out.print(":");
        }

    }

    static String[] zip(String[] strs){
        String[] rtn = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            int cut = -1;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j)=='0'){
                    cut = j;
                }else {
                    cut = j;
                    break;
                }
            }
            if(cut == strs[i].length()-1){
                rtn[i] = "";
            }
            else{
                rtn[i]=strs[i].substring(cut,strs[i].length());
            }
        }
        return rtn;
    }

    static String[] unzip(String[] strs){

        String[] rtn = new String[4];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length()==6) rtn[i]=strs[i];
            else if (strs[i].length()==0) rtn[i]="000000";
            else {
                int n = 6-strs[i].length();
                rtn[i]=strs[i];
                while (n!=0){
                    rtn[i]="0"+rtn[i];
                    n--;
                }
            }
        }
        for (int i = 0; i < rtn.length; i++) {
            if (rtn[i]==null)
                rtn[i]="000000";
        }
        return rtn;
    }
}