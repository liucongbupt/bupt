package leetcode.sort.DFS;

import java.util.ArrayList;

/**
 * @author liucong
 * @ClassName: No113PathSumII
 * @Description:
 * @date 2017年03月15日 下午6:05
 **/
public class No113PathSumII {
//    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
//        List<List<Integer>> rtn = new ArrayList<>();
//        if (root == null)
//            return rtn;
//
//        List<Integer> l = new ArrayList<>();
//        l.add(root.val);
//        dfs(root, sum - root.val, rtn, l);
//        return rtn;
//    }
//    public static void dfs(TreeNode root, int sum, List<List<Integer>> rtn, List<Integer> l){
//        if(root.left==null&&root.right==null&&sum==0){
//            rtn.add(new ArrayList<Integer>(l));
//        }
//
//        if(root.left!=null){
//            l.add(root.left.val);
//            dfs(root.left,sum-root.left.val,rtn,l);
//            l.remove(l.size()-1);
//        }
//
//        if(root.right!=null){
//            l.add(root.right.val);
//            dfs(root.right,sum-root.right.val,rtn,l);
//            l.remove(l.size()-1);
//        }
//    }
public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> solution = new ArrayList<Integer>();

    findSum(rst, solution, root, sum);
    return rst;
}

    private static void findSum(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution, TreeNode root, int sum){
        if (root == null) {
            return;
        }

        sum -= root.val;

        if (root.left == null && root.right == null) {
            if (sum == 0){
                solution.add(root.val);
                result.add(new ArrayList<Integer>(solution));
                solution.remove(solution.size()-1);
            }
            return;
        }

        solution.add(root.val);
        findSum(result, solution, root.left, sum);
        findSum(result, solution, root.right, sum);
        solution.remove(solution.size()-1);
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
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(1);
        a.left=b;
        a.right=c;
        b.left=d;
        c.left=e;
        c.right=f;
        d.left=g;
        d.right=h;
        f.left=i;
        f.right=j;
        pathSum(a,22);
    }
}
