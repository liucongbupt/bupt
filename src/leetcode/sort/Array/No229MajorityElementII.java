package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No229MajorityElementII
 * @Description:
 * @date 2017年03月02日 下午10:59
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
public class No229MajorityElementII {


    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        Integer n1=null, n2=null;
        int c1=0, c2=0;

        for(int i: nums){
            if(n1!=null && i==n1.intValue()){
                c1++;
            }else if(n2!=null && i==n2.intValue()){
                c2++;
            }else if(c1==0){
                c1=1;
                n1=i;
            }else if(c2==0){
                c2=1;
                n2=i;
            }else{
                c1--;
                c2--;
            }
        }

        c1=c2=0;

        for(int i: nums){
            if(i==n1.intValue()){
                c1++;
            }else if(i==n2.intValue()){
                c2++;
            }
        }

        if(c1>nums.length/3)
            result.add(n1);
        if(c2>nums.length/3)
            result.add(n2);

        return result;

    }
}
