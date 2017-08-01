package arg4.Graph;

import edu.princeton.cs.algs4.Digraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author liucong
 * @ClassName: DepthFirstOrder
 * @Description:
 * @date 2017年03月19日 上午11:33
 **/
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();

        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if(!marked[i])
                dfs(G,i);
        }
    }

    private void dfs(Digraph G,int v){
        pre.offer(v);
        marked[v]=true;
        for (int w:G.adj(v)
             ) {
            if(!marked[w])
                dfs(G,w);
        }
        post.offer(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }
    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
