package arg4.Sort;

/**
 * @author liucong
 * @ClassName: Selection
 * @Description:
 * @date 2016年10月23日 11:15 AM
 **/
public class Selection {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i; j < N; j++) {
                if(less(a[j],a[i])) min = j;
            }
            exch(a,i,min);
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

    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            if(less(a[i],a[i-1])) return false;
        }
        return  true;
    }

    public static void main(String[] args) {

    }
}
