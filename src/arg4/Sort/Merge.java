package arg4.Sort;

/**
 * @author liucong
 * @ClassName: Merge
 * @Description:
 * @date 2017年03月23日 上午10:46
 **/
public class Merge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux= new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a,int lo,int hi){
        if(lo>hi) return;
        int mid = (lo+hi)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    public static void merge(Comparable[] a, int lo, int mid , int hi){


        for (int i = lo; i < hi; i++) {
            aux[i]=a[i];
        }
        int i = lo;
        int j = mid+1;
        for (int k = lo; k < hi; k++) {
            if(i>lo) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(aux[i],aux[j])) a[k]=aux[i++];
            else a[k] = aux[j++];
        }

    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
