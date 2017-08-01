package leetcode.sort.DynamicProgramming;

/**
 * @author liucong
 * @ClassName: No338CountingBits
 * @Description:
 * @date 2017年04月07日 下午5:40
 **/
public class No338CountingBits {
    public static int[] countBits(int num) {
        int[] rtn = new int[num+1];
        for (int i = 0; i <= num; i++) {
            int n = i;
            while (n != 0) {
                rtn[i]++;
                n=(n-1)&n;
            }
        }
        return rtn;
    }
//    public int[] countBits(int num) {
//        int[] f = new int[num + 1];
//        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
//        return f;
//    }
    public static void main(String[] args) {
        int[] t = countBits(2);
    }
}
