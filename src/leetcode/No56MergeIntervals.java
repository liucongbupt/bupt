package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.No56MergeIntervals
 * @Description:
 * @date 2017年04月24日 上午10:52
 **/
public class No56MergeIntervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size()<=1)
            return intervals;

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> rtn = new LinkedList<>();
        for (Interval interval:intervals
                ) {
            if (interval.start<=end){
                end=Math.max(end,interval.end);
            }else {
                rtn.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        rtn.add(new Interval(start,end));
        return rtn;
    }
}
