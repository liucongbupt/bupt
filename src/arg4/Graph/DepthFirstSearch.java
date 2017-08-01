package arg4.Graph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author liucong
 * @ClassName: DepthFirstSearch
 * @Description:
 * @date 2017年03月18日 上午11:09
 **/
public class DepthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)
                ) {
            if (!marked[w]) {
                edgeTo[w]= v;
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public boolean hasPathTo(int V){
        return marked[V];
    }

    public Iterator<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s ; x=edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return (Iterator<Integer>) path;
    }


    public boolean[] getMarked() {
        return marked;
    }

    public static void main(String[] args) {
        File file = new File("algs4-data/tinyCG.txt");
        In in = new In(file);
        Graph g = new Graph(in);
//        Graph g = new Graph(in);
        DepthFirstSearch test = new DepthFirstSearch(g, 0);
        System.out.println(Arrays.toString(test.getMarked()));

    }
}
