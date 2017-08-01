package leetcode.sort.HashTable;

import leetcode.TreeNode;

import java.util.*;

/**
 * @author liucong
 * @ClassName: No508MostFrequentSubtreeSum
 * @Description:
 * @date 2017年03月30日 上午11:02
 **/
public class No508MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null) return new int[]{};
        if(root.left==null&&root.right==null) return new int[]{root.val};
        Map<Integer,Integer> map= new HashMap<>();
        count(root,map,Integer.MIN_VALUE);
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int max = list.get(0).getValue();
        List<Integer> alist = new ArrayList<>();
        for (int i:map.keySet()
             ) {
                if (map.get(i)==max)
                alist.add(i);
        }
        int[] rtn = new int[list.size()];
        for (int i = 0; i < rtn.length; i++) {
            rtn[i]=alist.get(i);
        }
        return  rtn;
    }
    private void count(TreeNode root,Map<Integer,Integer> map,int max){
        if(root==null) return;
        int sum = sum(root);
        map.put(sum,map.getOrDefault(sum,0)+1);
        max = max>map.get(sum)?max:map.get(sum);
        if(root.left!=null) count(root.left,map,max);
        if(root.right!=null) count(root.right,map,max);
    }
    private int sum(TreeNode root){
        int rtn = 0;
        if(root.left==null&&root.right==null)
            return root.val;
        rtn +=root.val;
        if(root.left!=null) rtn+=sum(root.left);
        if(root.right!=null) rtn+=sum(root.right);
        return rtn;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(-3);
        a.left=b;
        a.right=c;
        No508MostFrequentSubtreeSum test=new No508MostFrequentSubtreeSum();
        int[] s = test.findFrequentTreeSum(a);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
