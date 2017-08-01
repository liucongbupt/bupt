package arg4.Graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.io.File;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author liucong
 * @ClassName: DirectedDFS
 * @Description:
 * @date 2017年03月19日 上午10:34
 **/
public class DirectedDFS {
    private boolean marked[];
    private int[] edgeTo;
    private int s;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }
    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s:sources
             ) {
            dfs(G,s);
        }
    }

    private void dfs(Digraph G, int s) {
        marked[s] = true;
        for (int w: G.adj(s)
                ) {
            if (!marked[w]) {
                edgeTo[w]= s;
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
        Digraph G = new Digraph(new In(new File("algs-data/tinyDG.txt")));
        Bag<Integer> sources = new Bag<Integer>();
        Integer[] a = new Integer[]{1,2,3};
        for (int i = 0; i < a.length; i++) {
            sources.add(a[i]);
        }

        DirectedDFS reachable = new DirectedDFS(G,sources);
        for (int i = 0; i < G.V(); i++) {
            if (reachable.marked(i)) System.out.println(i+"");
        }
        System.out.println();
    }
}
