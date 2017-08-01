package Interview;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.lang.reflect.Array;

/**
 * Created by liucong on 2017/5/16.
 */
public class MaxHeap {

    public void sort(int[] a){
        int N = a.length;
        for (int i = N/2; i >= 1; i--) {
            sink(a,i,N);
        }
        while(N>1){
            swap(a,1,N-1);
            N--;
            sink(a,1,N);
        }

    }
    public void swim(int[] a,int k,int N){

        while (k>1&& a[k/2]<a[k]){
            swap(a,k,k/2);
            k = k/2;
        }
    }
    public void sink(int[] a,int k,int N){
        while (2*k<N){
            int j = 2*k;
            if(j+1<N&&a[j]<a[j+1])
                j++;
            if (a[k]>=a[j])
                break;
            swap(a,k,j);
            k = j;
        }
    }
    public void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public boolean less(int a,int b){
        return a<b;
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,3,5,4,6,8,9};
        MaxHeap mh = new MaxHeap();
        mh.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
