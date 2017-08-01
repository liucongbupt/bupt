package Interview;

import java.util.IllegalFormatException;

/**
 * @author liucong
 * @ClassName: FindKthInTwoSortedArry
 * @Description:
 * @date 2017年04月24日 下午7:07
 **/
public class FindKthInTwoSortedArry {
    public static int solve1(int[] A,int[] B,int k){
        if (k > A.length + B.length || k < 1) {
            throw new IllegalArgumentException("a");
        }

        // pointer of array A
        int pa = 0;
        // pointer of array B
        int pb = 0;
        //store the kth value
        int kthValue = 0;

        while (pa + pb != k) {
            int Ai = (pa == A.length) ? Integer.MAX_VALUE : A[pa];
            int Bj = (pb == B.length) ? Integer.MAX_VALUE : B[pb];

            if (Ai < Bj) {
                pa++;
                kthValue = Ai;
            } else {
                pb++;
                kthValue = Bj;
            }
        }
        return kthValue;
    }



//    int findKthMaxNumOfArrays(int *A, int m, int *B, int n, int k)
//    {
//        if(m == 0)return B[k-1];
//        if(n == 0)return A[k-1];
//        int i = m>>1, j = n>>1, *p, *q, t;
//        if(A[i] <= B[j])p = A, q = B;
//        else p = B, q = A, swap(i, j), swap(m, n);
//        t = i + j + 1;
//        if(t >= k)return func(p, m, q, j, k);
//        else if(t < k)return func(p+i+1, m-i-1, q, n, k-i-1);
//    }

//    static void swap(int i ,int j){
//        int tmp = i;
//         i = j;
//         j = tmp;
//    }
    static int solve2(int[] A,int as,int m,int[] B,int bs,int n,int k){
        if (m==0) return B[bs+k-1];
        if (n==0) return A[as+k-1];

        int i = m>>1,j = n>>1,t;

        if (A[as+i]>B[bs+j]){
            return solve2(B,bs,n,A,as,m,k);

        }

        t = i+j+1;

        if (t>=k)
            return solve2(A,as,m,B,bs,j,k);
        else
            return solve2(A,as+i+1,m-i-1,B,bs,n,k-i-1);
    }

    public static void main(String[] args) {
        int[] a = {1,2,2};
        int[] b = {1,2,3};
//        System.out.println(solve1(a,b,1));
//        System.out.println(solve1(a,b,2));
//        System.out.println(solve1(a,b,3));
//        System.out.println(solve1(a,b,4));
//        System.out.println(solve1(a,b,5));
//        System.out.println(solve1(a,b,6));
//        System.out.println(solve1(a,b,7));
//        System.out.println(solve1(a,b,8));

        System.out.println(solve2(a,0,a.length,b,0,b.length,1));
        System.out.println(solve2(a,0,a.length,b,0,b.length,2));
        System.out.println(solve2(a,0,a.length,b,0,b.length,3));
        System.out.println(solve2(a,0,a.length,b,0,b.length,4));
        System.out.println(solve2(a,0,a.length,b,0,b.length,5));
        System.out.println(solve2(a,0,a.length,b,0,b.length,6));
    }
}
