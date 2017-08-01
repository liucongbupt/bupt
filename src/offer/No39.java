package offer;

/**
 * @author liucong
 * @ClassName: No39
 * @Description:
 * @date 2017年04月03日 下午2:55
 **/
public class No39 {
    int treeDepth(BinaryTreeNode root){
        if(root==null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return Math.max(left,right)+1;
    }

    boolean isBanlanced(BinaryTreeNode root){
        if (root==null)
            return true;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int dif = left - right;
        if (Math.abs(dif)>1)
            return false;
        return isBanlanced(root.left)&&isBanlanced(root.right);
    }

    boolean isBanlanced2(BinaryTreeNode root){
        int[] depth = new int[1];
        return isBanlancedHelper(root,depth);
    }
    boolean isBanlancedHelper(BinaryTreeNode root,int[] depth){
        if (root==null){
            depth[0]=0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if(isBanlancedHelper(root.left,left)&&isBanlancedHelper(root.right,right)){
            int diff = left[0]-right[0];
            if (Math.abs(diff)<1){
                depth[0]=1+(left[0]>right[0]?left[0]:right[0]);
                return true;
            }
        }
        return false;
    }

}
