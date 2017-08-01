package arg4.Graph;

import edu.princeton.cs.algs4.Digraph;

/**
 * @author liucong
 * @ClassName: KosarajuSCC
 * @Description:
 * @date 2017年03月19日 下午1:52
 **/
public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder dfo = new DepthFirstOrder(G.reverse());
        for (int s:dfo.reversePost()
             ) {
            if(!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }

    private void dfs(Digraph G,int s){
        marked[s]=true;
        id[s]= count;
        for (int v:G.adj(s)
             ) {
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    public boolean stronglyConnected(int v,int w){
        return id[v]== id[w];
    }
    public int id(int v){
        return  id[v];
    }
    public int count(){
        return count;
    }
}
