package arg4.Graph;

import edu.princeton.cs.algs4.Graph;

/**
 * @author liucong
 * @ClassName: Cycle
 * @Description:Detect Cycle
 * @date 2017年03月18日 下午5:10
 **/
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if(!marked[i]){
                dfs(G,i,i);
            }
        }
    }

    private void dfs(Graph G,int v,int u){
        marked[v]=true;
        for (int w:G.adj(v)
             ) {
            if(!marked[w])
            dfs(G,w,v);
            else if(w!=u) hasCycle = true;
        }
    }
    public boolean hasCycle(){
        return hasCycle;
    }
}
