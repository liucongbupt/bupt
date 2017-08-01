package arg4.Graph;

import edu.princeton.cs.algs4.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: LazyPrimMST
 * @Description:
 * @date 2017年03月19日 下午7:15
 **/
public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;
    private double weight;
    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>();
        mst = new LinkedList<>();
        marked = new boolean[G.V()];
        visit(G,0);
        while (!pq.isEmpty()){
            Edge e = pq.delMin();
            int v = e.either(),w = e.other(v);
            if(marked[v]&&marked[w]) continue;
            mst.offer(e);
            if(!marked[v]) visit(G,v);
            if(!marked[w]) visit(G,w);
        }
    }

    private void visit(EdgeWeightedGraph G,int v){
        marked[v]= true;
        for (Edge e:G.adj(v)
             ) {
            if(!marked[e.other(v)]) {
                pq.insert(e);
                weight+=e.weight();
            }
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }
    public double weight(){
        return weight;
    }
}
