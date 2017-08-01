package offer;

/**
 * @author liucong
 * @ClassName: No19
 * @Description:
 * @date 2017年03月31日 下午3:27
 **/
public class No19 {

    public void mirrorRecursively(BinaryTreeNode root){
        if(root==null||root.left==null&&root.right==null)
            return;
        BinaryTreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;

        if(root.left!=null) mirrorRecursively(root.left);
        if(root.right!=null) mirrorRecursively(root.right);
    }
}
