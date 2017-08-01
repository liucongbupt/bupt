package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No342PowerofFour
 * @Description:
 * @date 2017年04月24日 下午10:45
 **/
public class No342PowerofFour {
    public boolean isPowerOfFour(int num) {
        if(num==0) return false;
        while(num%4==0) num/=4;
        return num==1;
    }
}
