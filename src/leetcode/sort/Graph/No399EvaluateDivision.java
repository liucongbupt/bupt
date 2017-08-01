package leetcode.sort.Graph;

import java.util.*;

/**
 * @author liucong
 * @ClassName: No399EvaluateDivision
 * @Description:
 * @date 2017年03月23日 下午8:55
 **/
public class No399EvaluateDivision {
    private void add(HashMap<String ,Map<String,Double>> graph,String VexStart,String VexEnd,double val){
        Map<String,Double> map;
        if(graph.containsKey(VexStart)){
            map = graph.get(VexStart);
        }else{
            map = new HashMap<>();
        }
        map.put(VexEnd,val);
        graph.put(VexStart,map);

    }
    private  double getValue(Map<String, Map<String, Double>> graph, String vexStart, String vexEnd) {
        if(vexStart==null||vexEnd==null) return -1;

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        Map<String,Double> map = new HashMap<>();
        
        queue.add(vexStart);
        set.add(vexStart);
        map.put(vexStart,1d);
        String currentNode,nextNode;
        while (!queue.isEmpty()){
             currentNode = queue.remove();
            for (Map.Entry<String,Double> arc:graph.get(currentNode).entrySet()
                 ) {
                 nextNode = arc.getKey();
                 map.put(nextNode,map.get(currentNode)*arc.getValue());
                if(nextNode.equals(vexEnd))
                    return map.get(nextNode);
                else if(!set.contains(nextNode))
                    queue.add(nextNode);
                set.add(nextNode);
            }


        }

        return -1;
    }

    public double[]  calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] rtn = new double[queries.length];
        HashMap<String,Map<String,Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            add(graph,equations[i][0],equations[i][1],values[i]);
            add(graph,equations[i][1],equations[i][0],1/values[i]);
        }
        for (int i = 0; i < queries.length; i++) {
           rtn[i]=getValue(graph,queries[i][0],queries[i][1]);
        }
        return rtn;
    }


    public static void main(String[] args) {
        No399EvaluateDivision test = new No399EvaluateDivision();
        String[][] a = {{"a","b"},{"b","c"}};
        double[] b =  {2.0,3.0};
        String[][] c ={{"a","c"},{"b","c"},{"a","e"}};
        test.calcEquation(a,b,c);
        System.out.println(1/2.5);
    }
}
