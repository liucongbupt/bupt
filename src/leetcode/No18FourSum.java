package leetcode;

import java.util.*;

/**
 * @author liucong
 * @ClassName: leetcode.No18FourSum
 * @Description:
 * @date 2017年04月19日 上午9:57
 **/
public class No18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        if(nums==null||nums.length<4){
            return rtn;
        }
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-3;i++){
            if(i==0||nums[i]!=nums[i-1]){
                for(int j = i+1;j<nums.length-2;j++){
                    if(j==i+1||nums[j]!=nums[j-1]){
                        int l = j+1;
                        int r = nums.length-1;
                        while(l<r){
                            int sum = nums[l]+nums[r]+nums[i]+nums[j];
                            if(sum==target){
                                List<Integer> list = new ArrayList<Integer>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[l]);
                                list.add(nums[r]);
                                rtn.add(list);
                                l++;
                                r--;

                                while(l<r&&nums[l]==nums[l-1]) l++;
                                while(l<r&&nums[r]==nums[r+1]) r--;
                            }else if(sum<target){
                                l++;
                            }else{
                                r--;
                            }
                        }
                    }
                }
            }
        }
        return rtn;
    }
//    public List<List<Integer>> fourSumX(int[] num, int target) {
//        Arrays.sort(num);
//
//        Map<Integer, List<int[]>> twoSumMap = new HashMap<>(); // for holding visited pair sums. All pairs with the same pair sum are grouped together
//        Set<List<Integer>> res = new HashSet<>();  // for holding the results
//
//        for (int i = 0; i < num.length; i++) {
//            // get rid of repeated pair sums
//            if (i > 1 && num[i] == num[i - 2]) continue;
//
//            for (int j = i + 1; j < num.length; j++) {
//                // get rid of repeated pair sums
//                if (j > i + 2 && num[j] == num[j - 2]) continue;
//
//                // for each pair sum, check if the pair sum that is needed to get the target has been visited.
//                if (twoSumMap.containsKey(target - (num[i] + num[j]))) {
//                    // if so, get all the pairs that contribute to this visited pair sum.
//                    List<int[]> ls = twoSumMap.get(target - (num[i] + num[j]));
//
//                    for (int[] pair : ls) {
//                        // we have two pairs: one is indicated as (pair[0], pair[1]), the other is (i, j).
//                        // we first need to check if they are overlapping with each other.
//                        int m1 = Math.min(pair[0], i);  // m1 will always be the smallest index
//                        int m2 = Math.min(pair[1], j);  // m2 will be one of the middle two indices
//                        int m3 = Math.max(pair[0], i);  // m3 will be one of the middle two indices
//                        int m4 = Math.max(pair[1], j);  // m4 will always be the largest index
//
//                        if (m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4) continue;  // two pairs are overlapping, so just ignore this case
//
//                        res.add(Arrays.asList(num[m1], num[Math.min(m2, m3)], num[Math.max(m2, m3)], num[m4]));  // else record the result
//                    }
//                }
//
//                // mark that we have visited current pair and add it to the corrsponding pair sum group.
//                // here we've encoded the pair indices i and j into an integer array of length 2.
//                twoSumMap.computeIfAbsent(num[i] + num[j], key -> new ArrayList<>()).add(new int[] {i, j});
//            }
//        }
//
//        return new ArrayList<List<Integer>>(res);
//    }
}
