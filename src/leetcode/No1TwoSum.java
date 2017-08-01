package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.No1TwoSum
 * @Description:
 * @date 2017年04月18日 下午10:54
 **/
public class No1TwoSum {

    public int[] twoSumX(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return null;

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] rtn = new int[2];
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                rtn[0] = map.get(target-nums[i]);
                rtn[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return rtn;
    }

//    public int[] twoSum(int[] nums, int target) {
//        if(nums==null||nums.length==0)
//            return null;
//
//        int[] nums2 = Arrays.copyOf(nums, nums.length);
//        Arrays.sort(nums2);
//        int a = 0;
//        int b = 0;
//        int i = 0;
//        int j = nums2.length-1;
//        while(i<j){
//            int sum = nums2[i]+nums2[j];
//            if(sum == target){
//                a=nums2[i];
//                b=nums2[j];
//                break;
//            }else if(sum<target){
//                i++;
//            }else{
//                j--;
//            }
//        }
//
//        int[] rtn = new int[2];
//        for (int k = 0; k < nums.length; k++) {
//            if (nums[k]==a){
//                rtn[0]=k;
//                break;
//            }
//        }
//        if (a!=b){
//            for (int k = 0; k < nums.length; k++) {
//                if (nums[k]==b){
//                    rtn[1]=k;
//                    break;
//                }
//            }
//        }else {
//            for (int k = 0; k < nums.length; k++) {
//                if (nums[k]==b&&k!=rtn[0]){
//                    rtn[1] = k;
//                    break;
//                }
//            }
//        }
//        return rtn;
//    }

    public static List<List<Integer>>TwoSum(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return null;
        List<List<Integer>> rtn = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum == target){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                i++;
                j--;
                rtn.add(list);

                while (i<j&&nums[j]==nums[j+1]) j--;
                while (i<j&&nums[i]==nums[i-1]) i++;
            }else if(sum<target){
                i++;
            }else{
                j--;
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        TwoSum(new int[]{1,1,1,1,2,3,4,5,6,7,8,9,9,9,9},10);
    }
}
