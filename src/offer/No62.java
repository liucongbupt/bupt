package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No62
 * @Description:
 * @date 2017年04月05日 下午2:43
 **/
public class No62 {
    public static void serialize(BinaryTreeNode root, List<Integer> result) {

        List<BinaryTreeNode> list = new LinkedList<>();
        list.add(root);
        BinaryTreeNode node;
        while (list.size() > 0) {
            node = list.remove(0);
            if (node == null) {
                result.add(null);
            }else {
                result.add(node.value);
                list.add(node.left);
                list.add(node.right);
            }
        }
    }

    public static BinaryTreeNode deserialize(List<Integer> result, int idx) {

        if (result.size() < 1 || idx < 0 || result.size() <= idx || result.get(idx) == null) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(result.get(idx));
        root.left = deserialize(result, idx * 2 + 1);
        root.right = deserialize(result, idx * 2 + 2);
        return root;

    }
}
