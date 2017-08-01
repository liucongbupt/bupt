package leetcode.sort.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liucong
 * @ClassName: No491IncreasingSubsequences
 * @Description:
 * @date 2017年03月26日 下午4:17
 **/
public class No491IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        List<Integer> holder = new ArrayList<>();
        findSubsequence(list, holder, 0, nums);
        List rtn = new ArrayList<>(list);
        return rtn;
    }

    private void findSubsequence(Set<List<Integer>> list, List<Integer> holder, int index, int[] nums) {
        if (holder.size() >= 2) {
            list.add(new ArrayList<>(holder));
        }

        for (int i = index; i < nums.length; i++) {
            if (holder.size() == 0 || holder.get(holder.size() - 1) < nums[i]) {
                holder.add(nums[i]);
                findSubsequence(list, holder, i + 1, nums);
                holder.remove(holder.size() - 1);
            }
        }
    }


}
