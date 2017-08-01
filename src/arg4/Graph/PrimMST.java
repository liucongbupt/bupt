package arg4.Graph;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.IndexMinPQ;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: PrimMST
 * @Description:
 * @date 2017年03月19日 下午8:32
 **/
public class PrimMST {
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G){
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
           distTo[i]=Double.MAX_VALUE;
        }
        pq = new IndexMinPQ<Double>(G.V());

        distTo[0]=0.0;
        pq.insert(0,0.0);

        while (!pq.isEmpty()){
            visit(G,pq.delMin());
        }

    }

    private void visit(EdgeWeightedGraph G,int v){
        marked[v]= true;
        for (Edge e:G.adj(v)
             ) {
            int w = e.other(v);
            if(marked[w]) continue;
            if(e.weight()<distTo[w]){
                edgeTo[w]=e;
                distTo[w]=e.weight();

                if(pq.contains(w)) pq.changeKey(w,distTo[w]);
                else pq.insert(w,distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges(){
        Queue q = new LinkedList<>();
        for (int i = 0; i < edgeTo.length; i++) {
            if(edgeTo[i]!=null)
                q.offer(edgeTo[i]);
        }
        return q;
    }

    public double weight(){
        double weight = 0;
        for (Edge e:edgeTo
             ) {
            weight=e.weight();
        }
        return  weight;
    }
}
