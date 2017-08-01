package leetcode.sort.BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No417PacificAtlanticWaterFlow
 * @Description:
 * @date 2017年03月22日 上午10:42
 **/
public class No417PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList();
        if(matrix.length == 0 || matrix[0].length == 0) return result;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] toPacific = new boolean[m][n];
        boolean[][] toAtlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            toPacific[i][0]=true;
            toAtlantic[i][n-1] = true;
            bfs(matrix,toPacific,i,0,m,n);
            bfs(matrix,toAtlantic,i,n-1,m,n);
        }

        for (int i = 0; i < n; i++) {
            toPacific[0][i]=true;
            toAtlantic[m-1][i]=true;
            bfs(matrix,toPacific,0,i,m,n);
            bfs(matrix,toAtlantic,m-1,i,m,n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(toPacific[i][j]&&toAtlantic[i][j])
                    result.add(new int[]{i,j});
            }
        }
        return result;
    }

    private void bfs(int[][] matrix,boolean[][] toOcean, int i, int j,int m,int n) {
        if((i>0&&matrix[i-1][j]>=matrix[i][j])&&(toOcean[i-1][j])){
            toOcean[i-1][j]=true;
            bfs(matrix,toOcean,i-1,j,m,n);
        }
        if((i<m-1&&matrix[i+1][j]>=matrix[i][j])&&(toOcean[i+1][j])){
            toOcean[i+1][j]=true;
            bfs(matrix,toOcean,i+1,j,m,n);
        }
        if((j>0&&matrix[i][j-1]>=matrix[i][j])&&(toOcean[i][j-1])){
            toOcean[i][j-1]=true;
            bfs(matrix,toOcean,i,j-1,m,n);
        }
        if((j<n-1&&matrix[i][j+1]>=matrix[i][j])&&(toOcean[i][j+1])){
            toOcean[i][j+1]=true;
            bfs(matrix,toOcean,i,j+1,m,n);
        }
    }
}
