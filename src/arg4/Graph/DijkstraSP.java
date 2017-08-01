package arg4.Graph;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

/**
 * @author liucong
 * @ClassName: Dijkstra
 * @Description:
 * @date 2017年03月20日 下午8:17
 **/
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;
    public DijkstraSP(EdgeWeightedDigraph G,int s){
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        pq = new IndexMinPQ<Double>(G.V());
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        distTo[s]=0;
        pq.insert(s,0.0);

        while(!pq.isEmpty()){
            relax(G,pq.delMin());
        }

    }

    private void relax(EdgeWeightedDigraph G,int s){
        for (DirectedEdge e:G.adj(s)
             ) {
            int w = e.to();
            if(distTo[w]>distTo[s]+e.weight()){
                distTo[w]=distTo[s]+e.weight();
                edgeTo[w]=e;
                if(pq.contains(s)) pq.changeKey(w,distTo[w]);
                else pq.insert(w,distTo[w]);
            }
        }
    }

    public double distTo(int v){
        return distTo[v];
    }
    public boolean hasPathtTo(int v){
        return  distTo[v]!=Double.MAX_VALUE;
    }
    public Iterable<DirectedEdge> pathTo(int v){
        if(!hasPathtTo(v)) return null;
        Stack<DirectedEdge> a = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e!=null ; e=edgeTo[e.from()]) {
            a.push(e);
        }
        return a;
    }

    public static void main(String[] args) {
    }

}
