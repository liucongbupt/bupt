package arg4.Graph;

import edu.princeton.cs.algs4.Digraph;
import sun.jvm.hotspot.utilities.Interval;

/**
 * @author liucong
 * @ClassName: Topological
 * @Description:
 * @date 2017年03月19日 上午11:47
 **/
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle dc = new DirectedCycle(G);
        if(!dc.hasCycle()){
            DepthFirstOrder dfo = new DepthFirstOrder(G);
            order = dfo.reversePost();
        }
    }
    public Iterable<Integer> order(){
        return order;
    }
    public boolean isDAG(){
        return order!=null;
    }
}
