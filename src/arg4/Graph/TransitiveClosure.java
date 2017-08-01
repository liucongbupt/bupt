package arg4.Graph;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

/**
 * @author liucong
 * @ClassName: TransitiveClosure
 * @Description:
 * @date 2017年03月19日 下午2:07
 **/
public class TransitiveClosure {
    private DirectedDFS[] all;
    TransitiveClosure(Digraph G){
        all = new DirectedDFS[G.V()];
        for (int i = 0; i < G.V(); i++) {
            all[i] = new DirectedDFS(G,i);
        }
    }
    boolean reachable(int v,int w){
        return  all[v].marked(w);
    }
}
