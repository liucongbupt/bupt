package leetcode.sort.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liucong
 * @ClassName: No4544SumII
 * @Description:
 * @date 2017年03月30日 上午10:54
 **/
public class No4544SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        int rtn = 0;
        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < C.length; j++) {
                map.put(C[i]+D[j],map.getOrDefault(C[i]+D[j],0)+1);
            }
        }
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < A.length; j++) {
                rtn+=map.getOrDefault(-1*(A[j]+B[i]),0);
            }
        }
        return rtn;

    }
}
