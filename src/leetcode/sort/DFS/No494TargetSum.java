package leetcode.sort.DFS;

/**
 * @author liucong
 * @ClassName: No494TargetSum
 * @Description:
 * @date 2017年03月15日 下午11:24
 **/
public class No494TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int index = 0;
        return subFind(nums,index,S);
    }
    public int subFind(int[] nums,int index,int S){
        if(index >= nums.length-1){
            if(nums[index]==0&&S==0)
                return 2;
            else{
                return (nums[index]==S||nums[index]==-S?1:0);
            }

        }
        int S1 = S - nums[index];
        int S2 = S + nums[index];
        index ++;
        return subFind(nums,index,S1)+subFind(nums,index,S2);
    }
}
