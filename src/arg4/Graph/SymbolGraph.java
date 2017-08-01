package arg4.Graph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

import java.util.Iterator;

/**
 * @author liucong
 * @ClassName: SymbolGraph
 * @Description:
 * @date 2017年03月19日 上午8:46
 **/
public class SymbolGraph {
    private ST<String, Integer> st;
    private String[] keys;
    private Graph G;

    public SymbolGraph(String stream, String sp) {
        st = new ST<>();
        In in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }
        keys = new String[st.size()];

        for (String name : st.keys()
                ) {
            keys[st.get(name)] = name;
        }
        G = new Graph(st.size());
        in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 0; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }

    }

    public void degreeOfSeparation(String stream, String split, String root, String find) {
        SymbolGraph sg = new SymbolGraph(stream, split);
        Graph G = sg.getG();

        if (!sg.contains(root)) {
            System.out.println(find + "not in database");
            return;
        }

        int s = sg.index(root);
        BreadthFirstPath bfs = new BreadthFirstPath(G, s);

        if (sg.contains(find)) {
            int t = sg.index(find);

            if (bfs.hasPathTo(t)) {
                for (int v:bfs.pathTo(t)
                     ) {
                    System.out.println("  " + sg.name(v));
                }
            } else {
                System.out.println("Not connnected");
            }
        } else {
            System.out.println("Not in database");
        }

    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph getG() {
        return G;
    }
}
