package offer;

/**
 * @author liucong
 * @ClassName: No28
 * @Description:
 * @date 2017年04月01日 下午10:46
 **/
public class No28 {
    public static void permutation(char[] str){
        if(str==null||str.length<-1)
            return;
        permutation(str,0);
    }

    public static void permutation(char[] str,int start){
        if(start==str.length-1){
            System.out.print(new String(str) + " ");
        }else {
            for (int i = start; i < str.length; i++) {
                swap(str,i,start);
                permutation(str,start+1);
//                swap(str,i,start);
            }
        }
    }

    public static void swap(char[] str,int i,int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public void combination(char[] str){
        if(str==null||str.length<-1)
            return;
        combination(str,0);
    }

    public void combination(char[] str,int start){

    }

    public static void main(String[] args) {
        permutation("abc".toCharArray());
    }
}
