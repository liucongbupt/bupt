package leetcode.sort.Math; /**
 * @author liucong
 * @ClassName: No204CountPrimes
 * @Description:
 * @date 2016年11月14日 上午10:55
 **/

/**
 * Description:

 Count the number of prime numbers less than a non-negative number, n.

 Credits:
 Special thanks to @mithmatt for adding this problem and creating all leetcode.Sort cases.

 Hint:

 Let's start with a isPrime function. To determine if a number is prime, we need to check if it is not divisible by any number less than n. The runtime complexity of isPrime function would be O(n) and hence counting the total prime numbers up to n would be O(n2). Could we do better?

 Show More Hint
 Subscribe to see which companies asked this question

 Hide Tags Hash Table leetcode.Math
 Hide Similar Problems (E) Ugly Number (M) Ugly Number II (M) Perfect Squares

 */
public class No204CountPrimes {

    public No204CountPrimes() {
    }

    public int countPrimes(int n) {
        if(n<3) return 0;
        int rtn = 0 ;
        int count = (int)Math.sqrt(n);

        int[] a = new int[n+1];
        for(int i = 0;i<n+1;i++) a[i]=i;

        for(int i = 2;i<=count;i++){
            if(a[i]!=0){
                for(int j = i+i;j<n+1;j+=i)
                    a[j]=0;
            }
        }

        for(int i =2;i<n;i++){
            if(a[i]!=0) rtn++;
        }
        return rtn;
    }
    public static void main(String[] args) {

    }
}
