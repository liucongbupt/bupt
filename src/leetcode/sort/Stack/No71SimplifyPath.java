package leetcode.sort.Stack;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author liucong
 * @ClassName: No71SimplifyPath
 * @Description:
 * @date 2017年04月11日 下午9:09
 **/
public class No71SimplifyPath {
    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir:path.split("/")
                ) {
            if (dir.equals("..")&&!stack.isEmpty())
                stack.pop();
            else if (!skip.contains(dir))
                stack.push(dir);
        }
        String rtn = "";
        for (String dir : stack) rtn = "/" + dir + rtn;
        return rtn.isEmpty() ? "/" : rtn;
    }

    public static void main(String[] args) {
//        System.out.println( simplifyPath("/home/"));
        System.out.println( simplifyPath("/."));
        System.out.println( simplifyPath("/"));
//        System.out.println( simplifyPath("/a/./b/../../c/"));


    }
}
