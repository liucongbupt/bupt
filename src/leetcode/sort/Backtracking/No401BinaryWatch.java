package leetcode.sort.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No401BinaryWatch
 * @Description:
 * @date 2017年04月10日 上午11:12
 **/
public class No401BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h=0; h<12; h++)
            for (int m=0; m<60; m++)
                if (Integer.bitCount(h * 64 + m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }
}
