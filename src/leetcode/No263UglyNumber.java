package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No263UglyNumber
 * @Description:
 * @date 2017年04月24日 下午10:07
 **/
public class No263UglyNumber {
    public boolean isUgly(int num) {
        if(num==0) return false;
        while(num%2==0)
            num/=2;
        while(num%3==0)
            num/=3;
        while(num%5==0)
            num/=5;
        return num==1;
    }
}
