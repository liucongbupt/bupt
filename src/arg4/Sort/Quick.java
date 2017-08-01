package arg4.Sort;

//import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

/**
 * @author liucong
 * @ClassName: Quick
 * @Description:
 * @date 2017年01月03日 下午3:35
 **/
public class Quick {
    public static void sort(Comparable[] a) {
//        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v))
                if (i == hi) break;

            // find item on hi to swap
            while (less(v, a[--j]))
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    public static void main(String[] args) {
        Integer [] a = new Integer[]{3,2,3,4,5,6,7,8,9};
        List<Integer> list = Arrays.asList(a);
//        List<Integer> list = new leetcode.LinkedList<Integer>();
//        for (int i = 0; i < 12; i++) {
//            list.add(i);
//        }
        Collections.shuffle(list);
        Collections.sort(list);
        Random r = new Random();
        Collections.shuffle(list,r);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

    }
}
