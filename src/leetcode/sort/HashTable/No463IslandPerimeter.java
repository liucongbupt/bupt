package leetcode.sort.HashTable;

/**
 * @author liucong
 * @ClassName: No463IslandPerimeter
 * @Description:
 * @date 2017年03月27日 下午2:49
 **/
public class No463IslandPerimeter {
    int[][] dirs = new int[][]{
            {1,0},//up
            {-1,0},//down
            {0,1},//right
            {0,-1}//left
    };
    public int islandPerimeter(int[][] grid) {
        int rtn = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    rtn+=4;
                    for (int[] dir:dirs
                         ) {
                        int row = m+dir[0];
                        int col = n+dir[1];
                        if((row>=0&&row<m)&&(col>=0&&col<n)){
                            if (grid[row][col]==1)
                                rtn--;
                        }
                    }
                }
            }
        }
        return rtn;
    }

    public class Solution {
        public int islandPerimeter(int[][] grid) {
            int islands = 0, neighbours = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        islands++; // count islands
                        if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                        if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                    }
                }
            }

            return islands * 4 - neighbours * 2;
        }
    }

}
