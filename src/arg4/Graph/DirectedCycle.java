package arg4.Graph;

import edu.princeton.cs.algs4.Digraph;

import java.util.Stack;

/**
 * @author liucong
 * @ClassName: DirectedCycle
 * @Description:
 * @date 2017年03月19日 上午11:09
 **/
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;
    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            dfs(G,i);
        }

    }

    private void dfs(Digraph G,int v){
        onStack[v]=true;
        marked[v]=true;
        for (int w:G.adj(v)
             ) {
            if(this.hasCycle()) return;
            else if(!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }else if(onStack[w]){
                cycle = new Stack<>();
                for (int x = v; x!=w ; x=edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v]=false;
    }
    public boolean hasCycle(){
        return cycle!=null;
    }

    public Iterable<Integer> cycle(){
        return  cycle;
    }

}
