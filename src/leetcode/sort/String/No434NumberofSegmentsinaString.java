package leetcode.sort.String;

/**
 * @author liucong
 * @ClassName: No434NumberofSegmentsinaString
 * @Description:
 * @date 2017年02月23日 上午8:58
 **/

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

 Please note that the string does not contain any non-printable characters.

 Example:


 Input: "Hello, my name is John"
 Output: 5
 Subscribe to see which companies asked this question.

 Hide Tags leetcode.String

 */
public class No434NumberofSegmentsinaString {
    public int countSegments(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
                res++;
        return res;
    }
    public static void main(String[] args) {

    }
}
