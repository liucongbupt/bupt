package offer;

/**
 * @author liucong
 * @ClassName: No59
 * @Description:
 * @date 2017年04月05日 上午11:50
 **/
public class No59 {
    static boolean isSystemmetrical(BinaryTreeNode root){
        return isSystemmetrical(root,root);
    }
    static boolean isSystemmetrical(BinaryTreeNode root1,BinaryTreeNode root2){
        if (root1==null&&root2==null)
            return true;
        if (root1==null||root2==null)
            return false;
        if (root1.value!=root2.value)
            return false;
        return isSystemmetrical(root1.left, root2.right)&&isSystemmetrical(root1.right,root2.left);
    }
}
