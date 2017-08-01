package leetcode.sort.BFS;

import java.util.*;

/**
 * @author liucong
 * @ClassName: No133CloneGraph
 * @Description:
 * @date 2017年03月22日 下午8:33
 **/
public class No133CloneGraph {

     class UndirectedGraphNode {
             int label;
             List<UndirectedGraphNode> neighbors;
             UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
         };
    HashMap<Integer,UndirectedGraphNode> map =new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        for (UndirectedGraphNode n:node.neighbors
             ) {
            clone.neighbors.add(n);
        }
        map.put(clone.label,clone);
        return clone;
    }
}
