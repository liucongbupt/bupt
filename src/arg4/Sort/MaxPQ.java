package arg4.Sort;

import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.Comparator;

/**
 * @author liucong
 * @ClassName: MaxPQ
 * @Description:
 * @date 2017年03月19日 下午6:23
 **/
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[]  pq;
    private int N=0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparator[maxN+1];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }
    public Key delMax(){
        Key max = pq[1];
        exch(1,N--);
        pq[N+1]=null;
        sink(1);
        return max;
    }

    private void exch(int i,int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    private boolean less(int i ,int j){
        return pq[i].compareTo(pq[j])<0;
    }
    private void sink(int k){
        while (2*k<N){
            int j = 2*k;
            if(j<N&&less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }
    private void swim(int k){
        while (k>1&&less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }
}
