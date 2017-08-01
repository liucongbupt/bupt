package leetcode.sort.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: No54201Matrix
 * @Description:
 * @date 2017年03月22日 下午8:53
 **/
public class No54201Matrix {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix.get(i).get(j)==0)
                    queue.add(new int[]{i,j});
                else
                    matrix.get(i).set(j,Integer.MAX_VALUE);
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!queue.isEmpty()){
            int[] cell = queue.poll();

            for (int[] d:dirs
                 ) {
                int r = cell[0]+d[0];
                int c = cell[1]+d[1];
                if(r<0||r>=m||c<0||c>=n||matrix.get(r).get(c)<=matrix.get(cell[0]).get(cell[1])+1) continue;
                queue.add(new int[]{r,c});
                matrix.get(r).set(c,matrix.get(cell[0]).get(cell[1])+1);
            }
        }
        return matrix;
    }
}
