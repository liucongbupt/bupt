package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No231PowerofTwo
 * @Description:
 * @date 2017年04月24日 下午8:34
 **/
public class No231PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n==0) return false;
        while(n%2==0) n/=2;
        return n==1;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
