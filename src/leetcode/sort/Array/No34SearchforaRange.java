package leetcode.sort.Array; /**
 * Created by liucong on 9/28/16.
 */

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class No34SearchforaRange {
    public No34SearchforaRange() {
    }

    public int[] searchRange(int[] nums, int target) {
        int[] rtn = new int[]{-1,-1};
        if(nums==null||nums.length==0){
            return rtn;
        }
        binary_search(nums,0,nums.length-1,target,rtn);
        return rtn;
    }
    public void binary_search(int[] nums, int low,int high,int goal,int[] rtn)
    {
        if(high<low)
            return;
        if(nums[low]==nums[high] && nums[low]==goal){
            rtn[0]=low;
            rtn[1]=high;
            return;
        }

        int middle = (high-low)/2 + low;
        if(nums[middle]>goal){
            binary_search(nums,low,middle-1,goal,rtn);
        }else if(nums[middle]<goal){
            binary_search(nums,middle+1,high,goal,rtn);
        }else{

            rtn[0]=rtn[1]=middle;
            int t1 = rtn[0];
            int t2 = rtn[1];

            while (t1>low&&nums[t1]==nums[t1-1]){
                t1--;
                rtn[0]=t1;
            }
            while(t2<high&&nums[t2]==nums[t2+1]){
                t2++;
                rtn[1]=t2;
            }


        }

        return;
    }
    public static void main(String[] args) {
        int a = 1/2;
        System.out.println(a);
    }
}
