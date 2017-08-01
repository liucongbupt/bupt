package leetcode.sort.DFS;

/**
 * @author liucong
 * @ClassName: No108ConvertSortedArraytoBinarySearchTree
 * @Description:
 * @date 2017年03月15日 下午2:42
 **/

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class No108ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null) return null;
        return buildBST(0,nums.length-1,nums);
    }

    private TreeNode buildBST(int lo,int high,int[] nums){
        if(lo>high)
            return null;
        int mid = (lo+high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=buildBST(lo,mid-1,nums);
        root.right=buildBST(mid+1,high,nums);
        return root;
    }

}
