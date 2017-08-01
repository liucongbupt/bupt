package leetcode.sort.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No257BinaryTreePaths
 * @Description:
 * @date 2017年03月15日 下午3:27
 **/
public class No257BinaryTreePaths {
    List<String> rtn = new ArrayList<>();
    public List<String> binaryTreePaths2(TreeNode root) {
        if(root==null){
            return rtn;
        }
        findPaths(root,root.val+"");
        return rtn;
    }

    private void findPaths(TreeNode node, String path) {
        if(node.left==null&&node.right==null){
            rtn.add(path);
        }
        if(node.left!=null){
            findPaths(node.left,path+"->"+node.left.val);
        }
        if(node.right!=null){
            findPaths(node.right,path+"->"+node.right.val);
        }
    }

}
