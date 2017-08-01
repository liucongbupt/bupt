package offer;

import java.security.PublicKey;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No50
 * @Description:
 * @date 2017年04月04日 下午7:04
 **/
public class No50 {
    /**
     * 树的结点定义
     */
    private static class TreeNode {
        int val;

        List<TreeNode> children = new LinkedList<>();


        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
    public static void getNodePath(TreeNode root,TreeNode target,List<TreeNode> path){
        if (root==null){
            return;
        }
        path.add(root);
        List<TreeNode> children = root.children;
        for (TreeNode child:children
             ) {
            if (child==target){
                path.add(child);
                return;
            }else{
                getNodePath(child,target,path);
            }
        }
        path.remove(path.size()-1);
    }

    public static TreeNode getLastCommonNode(List<TreeNode> p1,List<TreeNode> p2){
        Iterator<TreeNode> t1 = p1.iterator();
        Iterator<TreeNode> t2 = p2.iterator();
        TreeNode last = null;
        while (t1.hasNext()&&t2.hasNext()){
            if (t1.next()==t2.next()){
                last=t1.next();
            }else {
                break;
            }
        }
        return last;
    }

    public static TreeNode getLastCommonParent(TreeNode root,TreeNode p1,TreeNode p2){
        if (root==null||p1==null||p2==null){
            return null;
        }

        List<TreeNode> path1 = new LinkedList<>();
        List<TreeNode> path2 = new LinkedList<>();
                getNodePath(root,p1,path1);
                getNodePath(root,p2,path2);
        return getLastCommonNode(path1,path2);
    }
}
