package leetcode.sort.Stack;

/**
 * @author liucong
 * @ClassName: No331VerifyPreorderSerializationofaBinaryTree
 * @Description:
 * @date 2017年04月12日 上午9:37
 **/
public class No331VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] per = preorder.split(",");
        int diff = 1;
        for (String node:per
             ) {
            if (--diff<0) return false;
            if (!node.equals("#")) diff+=2;
        }
        return diff==0;
    }
}
