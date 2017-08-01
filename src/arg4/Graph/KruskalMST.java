package arg4.Graph;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.EdgeWeightedGraph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: KruskalMST
 * @Description:
 * @date 2017年03月19日 下午10:20
 **/
public class KruskalMST {
    private Queue<Edge> mst;
    private double weight;

    public KruskalMST(EdgeWeightedGraph G){
        mst = new LinkedList<>();
        MinPQ<Edge> pq = new MinPQ<Edge>((Comparator<Edge>) G.edges());
        UF uf = new UF(G.V());
        while (!pq.isEmpty()&&mst.size()<G.V()-1){
            Edge e = pq.delMin();
            int v = e.either(),w=e.other(v);
            if(uf.connected(v,w)) continue;
            uf.connected(v,w);
            mst.offer(e);
            weight+=e.weight();
        }
    }


    public Iterable<Edge> edges(){
        return mst;
    }
    public double weight(){
        return weight;
    }

}
