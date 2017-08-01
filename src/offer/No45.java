package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No45
 * @Description:
 * @date 2017年04月04日 下午3:59
 **/
public class No45 {
    int lastRemaining(int n,int m){
        if (n<1||m<1)
            return -1;

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size()>1){
            index = index + m;
            index = index%(list.size())-1 ;
            if (index<0){
                index = list.size()-1;
            }
//            System.out.println(index+":"+list.get(index));
            list.remove(index);
        }
//        System.out.println("aaaaaaaaaa");
        return list.get(0);
    }

    int LastRemain2(int n,int m){
        if (n<1||m<1){
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last+m)%i;
        }
        return last;
    }

    public static void main(String[] args) {
        No45 test = new No45();

        System.out.println(test.lastRemaining(5, 3)); // 最后余下3
        System.out.println(test.lastRemaining(5, 2)); // 最后余下2
        System.out.println(test.lastRemaining(6, 7)); // 最后余下4
        System.out.println(test.lastRemaining(6, 6)); // 最后余下3
        System.out.println(test.lastRemaining(0, 0)); // 最后余下-1
    }


}
