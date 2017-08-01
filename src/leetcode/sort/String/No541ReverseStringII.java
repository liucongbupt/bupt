package leetcode.sort.String;

import org.omg.CORBA.MARSHAL;

/**
 * @author liucong
 * @ClassName: No541ReverseStringII
 * @Description:
 * @date 2017年04月12日 下午8:17
 **/
public class No541ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] arr= s.toCharArray();
        int n = arr.length;
        int i=0;
        while (i<n){
            int j = Math.min(i+k-1,n-1);
            swap(arr,i,j);
            i+=2*k;
        }
        return String.valueOf(arr);
    }

    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
