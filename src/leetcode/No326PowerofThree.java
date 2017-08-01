package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No326PowerofThree
 * @Description:
 * @date 2017年04月24日 下午8:40
 **/
public class No326PowerofThree {
    public boolean isPowerOfThree(int n) {
        if(n==0) return false;
        while(n%3==0) n/=3;
        return (n==1);
    }
}
