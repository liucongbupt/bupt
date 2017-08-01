package leetcode.sort.Math; /**
 * @author liucong
 * @ClassName: leetcode.Math.No372SuperPow
 * @Description:
 * @date 2016年11月21日 下午4:41
 **/

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

 Example1:

 a = 2
 b = [3]

 Result: 8
 Example2:

 a = 2
 b = [1,0]

 Result: 1024
 Credits:
 Special thanks to @Stomach_ache for adding this problem and creating all leetcode.Sort cases.

 Subscribe to see which companies asked this question

 Hide Tags leetcode.Math
 Hide Similar Problems (M) Pow(x, n)

 */
public class No372SuperPow {
    public No372SuperPow() {
    }
    private int mod=1337;
    public int superPow(int a, int[] b) {
        int n = b.length;
        int ans = 1;
        for (int i = n-1;i>=0 ; i--) {
            ans = ans * quickPow(a,b[i]) %mod;
            a = quickPow(a,10);
        }
        return ans;
    }

    public int quickPow(int a,int b) {
        int ans = 1;
        a = a % mod;
        while(b>0){
            if((b&1)==1) ans = ans * a % mod;
            a = a * a % mod ;
            b >>= 1;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
