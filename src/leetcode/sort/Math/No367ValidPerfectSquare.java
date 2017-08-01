package leetcode.sort.Math; /**
 * @author liucong
 * @ClassName: leetcode.Math.No367ValidPerfectSquare
 * @Description:
 * @date 2016年11月21日 下午4:29
 **/

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True
 Example 2:

 Input: 14
 Returns: False
 Credits:
 Special thanks to @elmirap for adding this problem and creating all leetcode.Sort cases.

 Subscribe to see which companies asked this question

 Hide Tags Binary Search leetcode.Math
 Hide Similar Problems (M) Sqrt(x)

 */
public class No367ValidPerfectSquare {
    public No367ValidPerfectSquare() {

    }

    public boolean isPerfectSquare(int num) {
        int start  = 1;
        int end = num;
        while(start<=end){
            long mid = (long)(end+start)/2;
            if(mid*mid<num)
                start = (int)mid +1;
            else if(mid*mid>num)
                end = (int)mid -1;
            else{
                if(mid%1==0){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
