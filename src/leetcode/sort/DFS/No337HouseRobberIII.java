package leetcode.sort.DFS;

/**
 * @author liucong
 * @ClassName: No337HouseRobberIII
 * @Description:
 * @date 2017年03月27日 上午9:39
 **/
public class No337HouseRobberIII {
    public  int  rob(TreeNode root) {
        int[] rtn = dfs(root);
        return Math.max(rtn[0],rtn[1]);
    }
    private  int[] dfs(TreeNode root){
        if(root==null) return new int[2];
        int[] left = dfs(root.left);
        int[] right=dfs(root.right);
        int[] res = new int[2];
        res[0]= left[1]+right[1]+root.val;
        res[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return res;
    }

    /**
     *
     *  5
     5
     / \
     4   8
     /   / \
     11  13  4
     /  \    / \
     7    2  5   1
     * @param args
     */
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
//        TreeNode e = new TreeNode(1);
        a.right=b;
        b.right=c;
        c.right=d;
//        c.right=e;
    }
}
