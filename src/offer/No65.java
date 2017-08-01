package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No65
 * @Description:
 * @date 2017年04月05日 下午2:43
 **/
public class No65 {
    public static List<Integer> maxInWindows(List<Integer> data,int size){
        List<Integer> maxWindows = new LinkedList<>();

        if (data==null||size<1|data.size()<1)
            return maxWindows;
        Deque<Integer> idx = new LinkedList<>();
        for (int i = 0; i < size&&i<data.size(); i++) {
            while (!idx.isEmpty()&&data.get(i)>=data.get(idx.getFirst())){
                idx.removeLast();
            };
            idx.addLast(i);
        }

        for (int i = size; i < data.size(); i++) {
            maxWindows.add(data.get(idx.getFirst()));
            while (!idx.isEmpty()&&data.get(i)>=data.get(idx.getFirst())){
                idx.removeLast();
            }
            if (!idx.isEmpty()&&idx.getFirst()<=i-size){
                idx.removeFirst();
            }
            idx.addLast(i);
        }

        // 最后一个窗口最大值入队
        maxWindows.add(data.get(idx.getFirst()));

        return maxWindows;
    }

}
