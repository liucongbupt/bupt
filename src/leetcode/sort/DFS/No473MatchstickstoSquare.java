package leetcode.sort.DFS;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: No473MatchstickstoSquare
 * @Description:
 * @date 2017年03月26日 下午4:22
 **/
public class No473MatchstickstoSquare {

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        int max = 0;
        for (int num : nums){
            sum += num;
            max=Math.max(max,num);
        }
        int len = sum/4;
        if (sum % 4 != 0)
            return false;
        if(max>len)
            return false;

        Arrays.sort(nums);
        boolean[] isUsed = new boolean[nums.length];
        for (int i = 0; i < 4; i++) {
            if(!dfs(nums,isUsed,nums.length-1,len))
                return false;
        }
        return true;
    }

    private boolean dfs(int[] nums, boolean[] isUsed, int index, int target) {
        if(target<0)
            return false;
        if(target==0)
            return true;
        for (int i = index; i >=0; i--) {
            if (!isUsed[i]){
                isUsed[i]=true;
                if(dfs(nums,isUsed,i-1,target-nums[i])) return true;
                else
                    isUsed[i]=false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No473MatchstickstoSquare ms = new No473MatchstickstoSquare();
        int[] a = new int[]{1,1,2,2,2};
        System.out.println(ms.makesquare(a));
    }
}
