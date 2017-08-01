package leetcode.sort.Math;

/**
 * @author liucong
 * @ClassName: No423ReconstructOriginalDigitsfromEnglish
 * @Description:
 * @date 2016年11月22日 下午3:22
 **/

import java.util.Arrays;

/**
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

 Note:
 Input contains only lowercase English letters.
 Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 Input length is less than 50,000.
 Example 1:
 Input: "owoztneoer"

 Output: "012"
 Example 2:
 Input: "fviefuro"

 Output: "45"
 Subscribe to see which companies asked this question

 Hide Tags leetcode.Math

 */
public class No423ReconstructOriginalDigitsfromEnglish {

    public No423ReconstructOriginalDigitsfromEnglish() {

    }

    public String originalDigits(String s) {
        char[] od = s.toCharArray();
        Arrays.sort(od);
        int[] temp = new int[15];//分别代表e,f,g,h,i,n,o,r,s,t,u,v,w,x,z

        for (int i = 0; i < od.length; i++) {
            switch (od[i]){
                case 'e':
                    temp[0]++;
                    break;
                case 'f':
                    temp[1]++;
                    break;
                case 'g':
                    temp[2]++;
                    break;
                case 'h':
                    temp[3]++;
                    break;
                case 'i':
                    temp[4]++;
                    break;
                case 'n':
                    temp[5]++;
                    break;
                case 'o':
                    temp[6]++;
                    break;
                case 'r':
                    temp[7]++;
                    break;
                case 's':
                    temp[8]++;
                    break;
                case 't':
                    temp[9]++;
                    break;
                case 'u':
                    temp[10]++;
                    break;
                case 'v':
                    temp[11]++;
                    break;
                case 'w':
                    temp[12]++;
                    break;
                case 'x':
                    temp[13]++;
                    break;
                case 'z':
                    temp[14]++;
                    break;
            }
        }

        int[] rtn  = new int[10];

        rtn[0] = temp[14];//确定0的个数zero
        temp[14]-=rtn[0];//z
        temp[0]-=rtn[0];//e
        temp[7]-=rtn[0];//r
        temp[6]-=rtn[0];//o

        rtn[8] = temp[2];//g确定8的个数eight
        temp[0]-=rtn[8];//e
        temp[4]-=rtn[8];//i
        temp[2]-=rtn[8];//g
        temp[3]-=rtn[8];//h
        temp[9]-=rtn[8];//t

        rtn[4] = temp[10];//u确定4的个数four
        temp[1]-=rtn[4];//f
        temp[6]-=rtn[4];//o
        temp[10]-=rtn[4];//u
        temp[7]-=rtn[4];//r

        rtn[5] = temp[1];//f确定5的个数five
        temp[1]-=rtn[5];//f
        temp[4]-=rtn[5];//i
        temp[11]-=rtn[5];//v
        temp[0]-=rtn[5];//e

        rtn[6] = temp[13];//x确定6的个数six
        temp[8]-=rtn[6];//s
        temp[4]-=rtn[6];//i
        temp[13]-=rtn[6];//x

        rtn[7] = temp[8];//s确定7的个数seven
        temp[8]-=rtn[7];//s
        temp[0]-=rtn[7];//e
        temp[11]-=rtn[7];//v
        temp[0]-=rtn[7];//e
        temp[5]-=rtn[7];//n

        rtn[2] = temp[12];//w确定2的个数two
        temp[9]-=rtn[2];//t
        temp[12]-=rtn[2];//t
        temp[6]-=rtn[2];//o

        rtn[3] = temp[9];//t确定3的个数three
        temp[9]-=rtn[3];//t
        temp[3]-=rtn[3];//h
        temp[7]-=rtn[3];//r
        temp[0]-=2*rtn[3];//e

        rtn[1] = temp[6];//o确定1的个数one
        temp[6]-=rtn[1];//o
        temp[5]-=rtn[1];//n
        temp[0]-=rtn[1];//e

        rtn[9] = temp[4];//i确定9的个数nine
        temp[5]-=2*rtn[9];//n
        temp[4]-=rtn[9];//i
        temp[0]-=rtn[9];//e

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < rtn.length; i++) {
            while(rtn[i]>0){
                sb.append(i);
                rtn[i]--;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        No423ReconstructOriginalDigitsfromEnglish aa = new No423ReconstructOriginalDigitsfromEnglish();
        System.out.println(aa.originalDigits("fviefuro"));
    }
}
