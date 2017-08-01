package arg4.Graph;

import edu.princeton.cs.algs4.Graph;

/**
 * @author liucong
 * @ClassName: TwoColors
 * @Description:
 * @date 2017年03月18日 下午5:27
 **/
public class TwoColors {
    private boolean[] marked;
    private  boolean[] color;
    private boolean isTwoColor = true;

    public TwoColors(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if(!marked[i])
                dfs(G,i);
        }
    }
    private void dfs(Graph G,int v){
        marked[v]=true;
        for (int w:G.adj(v)
             ) {
            if(!marked[w]) {
                color[w]=!color[v];
                dfs(G, w);
            }else if(color[w]==color[v]) isTwoColor=false;
        }
    }

    public boolean isTwoColor() {
        return isTwoColor;
    }
}
