package leetcode.sort.Math; /**
 * @author liucong
 * @ClassName: leetcode.Math.No400NthDigit
 * @Description:
 * @date 2016年11月22日 上午10:28
 **/

/**
 *Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

 Note:
 n is positive and will fit within the range of a 32-bit signed integer (n < 231).

 Example 1:

 Input:
 3

 Output:
 3
 Example 2:

 Input:
 11

 Output:
 0

 Explanation:
 The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 Subscribe to see which companies asked this question

 Hide Tags leetcode.Math

 */
public class No400NthDigit {
    public No400NthDigit() {
    }
    public int findNthDigit(int n) {
        long digit = 1;
        long base = 9;
        long ith = 1;
        while(n>base*digit){
            n-= base *(digit++);
            ith += base;
            base*=10;
        }
        long num = ith+(n-1)/digit;
        long position = (n-1)%digit;
        String rtn = String.valueOf(num);
        int ret = rtn.charAt((int)position)-'0';
        return ret;
    }
    public static void main(String[] args) {
        No400NthDigit nd = new No400NthDigit();
        System.out.println(nd.findNthDigit(3));
    }
}
