package leetcode.sort.Backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No89GrayCode
 * @Description:
 * @date 2017年04月10日 下午8:08
 **/
public class No89GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) {
            list.add(i^i>>1);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(1^1);
        System.out.println(0^1);
        System.out.println(1^0);
        System.out.println(0^0);
    }
}
