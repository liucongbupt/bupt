package offer;

/**
 * @author liucong
 * @ClassName: No34
 * @Description:
 * @date 2017年04月02日 下午10:43
 **/
public class No34 {

    public int nthUglyNumber(int n) {
        if (n<=0)
            return 0;

        int[] ugly = new int[n];

        ugly[0]=1;
        int next = 1;

        int m2 = 0;
        int m3 = 0;
        int m5 = 0;

        while (next<n){
            int min  = Min(ugly[m2]*2,ugly[m3]*3,ugly[m5]*5);
            ugly[next]=min;

            while (ugly[m2]*2<=ugly[next])
                m2++;
            while (ugly[m3]*3<=ugly[next])
                m3++;
            while (ugly[m5]*5<=ugly[next])
                m5++;

            next++;
        }
        return ugly[next-1];
    }
    int Min(int a,int b,int c){
        return Math.min(Math.min(a,b),c);
    }
}
