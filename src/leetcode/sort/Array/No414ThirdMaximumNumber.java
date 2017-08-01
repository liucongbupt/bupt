package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No414ThirdMaximumNumber
 * @Description:
 * @date 2017年02月26日 上午8:59
 **/

import java.util.TreeSet;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.
 Subscribe to see which companies asked this question.

 Hide Tags leetcode.Array
 Hide Similar Problems (M) Kth Largest Element in an leetcode.Array

 */
public class No414ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int num:nums){
            set.add(num);
            if(set.size() > 3){
                set.remove(set.first());
            }
        }
        return set.size() == 3 ? set.first() : set.last();
    }

    public int thirdMaxx(int[] nums) {
//        Integer max1 = null;
//        Integer max2 = null;
//        Integer max3 = null;
//        for (Integer n : nums) {
//            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
//            if (max1 == null || n > max1) {
//                max3 = max2;
//                max2 = max1;
//                max1 = n;
//            } else if (max2 == null || n > max2) {
//                max3 = max2;
//                max2 = n;
//            } else if (max3 == null || n > max3) {
//                max3 = n;
//            }
//        }
//        return max3 == null ? max1 : max3;

        Integer first = null;
        Integer second = null;
        Integer third = null;
        for(Integer n :nums){
            if(n.equals(first)||n.equals(second)||n.equals(third)) continue;
            if(first == null||n>first){
                third=second;
                second=first;
                first=n;
            }else if(second==null||n>second){
                third=second;
                second=n;
            }else if(third==null||n>third){
                third=n;
            }
        }
        return third==null?first:third;
    }
}
