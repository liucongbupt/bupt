package leetcode.sort.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No56MergeIntervals
 * @Description:
 * @date 2017年02月26日 下午11:28
 **/

/**
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class No56MergeIntervals {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals){
        if(intervals==null||intervals.size()<=1){
            return intervals;
        }
        Collections.sort(intervals,new IntevalComparator());
        List<Interval> list = new ArrayList<Interval>();
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curt = intervals.get(i);
            if(curt.start<=last.end){
                last.end = Math.max(last.end,curt.end);
            }else{
                list.add(last);
                last=curt;
            }
        }

        list.add(last);
        return list;

    }

    private class IntevalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    }


}

