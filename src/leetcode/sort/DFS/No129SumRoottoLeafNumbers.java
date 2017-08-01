package leetcode.sort.DFS;

/**
 * @author liucong
 * @ClassName: No129SumRoottoLeafNumbers
 * @Description:
 * @date 2017年03月26日 下午3:20
 **/
public class No129SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs (TreeNode root,int s){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return s*10+root.val;
        return dfs(root.left,root.val)+dfs(root.right,root.val);
    }
}
