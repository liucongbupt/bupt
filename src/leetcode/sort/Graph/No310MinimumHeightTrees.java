package leetcode.sort.Graph;

import java.util.*;

/**
 * @author liucong
 * @ClassName: No310MinimumHeightTrees
 * @Description:
 * @date 2017年03月25日 下午9:02
 **/
public class No310MinimumHeightTrees {

    //    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        List<Integer> rtn = new ArrayList<>();
//        if(n==0)
//            return rtn;
//        if(edges.length==0||edges[0].length==0){
//            for (int i = 0; i < n; i++) {
//                rtn.add(i);
//            }
//            return rtn;
//        }
//        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();//edge
//        for (int i = 0; i < edges.length; i++) {
//            if(!map.containsKey(edges[i][0])){
//                map.put(edges[i][0],new ArrayList<>());
//            }
//            if(!map.containsKey(edges[i][1])){
//                map.put(edges[i][1],new ArrayList<>());
//            }
//            map.get(edges[i][0]).add(edges[i][1]);
//            map.get(edges[i][1]).add(edges[i][0]);
//        }
//        int[] depth = new int[n];
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            depth[i]=dfs(map,i,new int[n],1,Integer.MIN_VALUE);
//            min=Math.min(min,depth[i]);
//        }
//        for (int i = 0; i < n; i++) {
//            if(depth[i]==min)
//                rtn.add(i);
//        }
//        return rtn;
//
//    }
//    private  int dfs(HashMap<Integer,ArrayList<Integer>> G,int s,int[] depth,int current,int max){
//        depth[s]=current;
//        for (int v:G.get(s)
//             ) {
//            if(depth[v]==0){
//                max = dfs(G,v,depth,depth[s]+1,max);
//            }
//        }
//        return max>=depth[s]?max:depth[s];
//    }
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        List<Integer> rtn = new ArrayList<Integer>();
//        if (n == 0)
//            return rtn;
//        if (edges.length == 0 || edges[0].length == 0) {
//            for (int i = 0; i < n; i++) {
//                rtn.add(i);
//            }
//            return rtn;
//        }
//        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();//edge
//        for (int i = 0; i < edges.length; i++) {
//            if (!map.containsKey(edges[i][0])) {
//                map.put(edges[i][0], new ArrayList<>());
//            }
//            if (!map.containsKey(edges[i][1])) {
//                map.put(edges[i][1], new ArrayList<>());
//            }
//            map.get(edges[i][0]).add(edges[i][1]);
//            map.get(edges[i][1]).add(edges[i][0]);
//        }
//        int[] depth = new int[n];
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            boolean[] marked = new boolean[n];
//            Queue<Integer> queue = new LinkedList<>();
//            queue.offer(i);
//            int size = 1;
//            int length = 1;
//            while (size > 0) {
//                for (int j = 0; j < size; j++) {
//                    int w = queue.poll();
//                    marked[w]=true;
//                    for (int u:map.get(w)
//                            ) {
//                        if(!marked[u])
//                            queue.add(u);
//                    }
//                }
//                size = queue.size();
//                length++;
//            }
//            min = Math.min(min, length);
//            depth[i]=length;
//        }
//        for (int i = 0; i < n; i++) {
//            if(depth[i]==min)
//                rtn.add(i);
//        }
//        return rtn;
//    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       List<Integer> leaves = new LinkedList<>();
        if(n==1){
            return Collections.singletonList(0);
        }
        HashMap<Integer,Set<Integer>> G = new HashMap<>();
        for (int i = 0; i < n; i++) {
            G.put(i, new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            G.get(edges[i][0]).add(edges[i][1]);
            G.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if(G.get(i).size()==1)
                leaves.add(i);
        }

        while (n>2){
            n-=leaves.size();
            List<Integer> newList = new LinkedList<>();
            for (int leaf:leaves
                 ) {
                for (int newLeaf:G.get(leaf)
                     ) {
                        G.get(leaf).remove(newLeaf);
                        G.get(newLeaf).remove(leaf);
                        if(G.get(newLeaf).size()==1)
                            newList.add(newLeaf);
                }
            }
            leaves = newList;
        }

        return leaves;

    }

    public static void main(String[] args) {
        No310MinimumHeightTrees test = new No310MinimumHeightTrees();
        int[][] a = {{1,2},{1,0},{1,3}};
        int b = 4;
        List<Integer> list = test.findMinHeightTrees(b, a);
        System.out.println(list.toArray());
    }
}
