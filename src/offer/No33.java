package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author liucong
 * @ClassName: No33
 * @Description:
 * @date 2017年04月02日 下午10:13
 **/
public class No33 {

    public static String printMinNumber(String[] array){
        if (array==null||array.length<1)
            throw new IllegalArgumentException("Array must contain value");
        Collections.sort(Arrays.asList(array), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1==null||o2==null)
                    throw new IllegalArgumentException("Arg Not Null!!!!");
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder rtn = new StringBuilder();
        for (String str:array
             ) {
            rtn.append(str);
        }
        return rtn.toString();
    }
    public static void main(String[] args) {

        String[] data = {"3", "5", "1", "4", "2"};
        System.out.println(printMinNumber(data));

        String[] data2 = {"3", "32", "321"};
        System.out.println(printMinNumber(data2));

        String[] data3 = {"3", "323", "32123"};
        System.out.println(printMinNumber(data3));

        String[] data4 = {"1", "11", "111"};
        System.out.println(printMinNumber(data4));

        String[] data5 = {"321"};
        System.out.println(printMinNumber(data5));
    }
}
