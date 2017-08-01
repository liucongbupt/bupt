package leetcode.sort.String;

/**
 * @author liucong
 * @ClassName: No521LongestUncommonSubsequenceI
 * @Description:
 * @date 2017年04月12日 下午3:23
 **/
public class No521LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
