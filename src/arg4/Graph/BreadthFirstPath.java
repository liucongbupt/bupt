package arg4.Graph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

import java.io.File;
import java.util.*;

/**
 * @author liucong
 * @ClassName: BreadthFirstPath
 * @Description:
 * @date 2017年03月18日 下午3:32
 **/
public class BreadthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BreadthFirstPath(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s]=true;
        queue.offer(s);
        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int w:G.adj(v)
                 ) {
                if(!marked[w]){
                    edgeTo[w] =v;
                    marked[w]=true;
                    queue.offer(w);
                }
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public boolean hasPathTo(int V){
        return marked[V];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s ; x=edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return (Iterable<Integer>) path;
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
