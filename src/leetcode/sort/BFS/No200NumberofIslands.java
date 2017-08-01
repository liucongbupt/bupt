package leetcode.sort.BFS;

/**
 * @author liucong
 * @ClassName: No200NumberofIslands
 * @Description:
 * @date 2017年03月22日 下午4:52
 **/
public class No200NumberofIslands {
    public int numIslands(char[][] grid) {
        int nums=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]!='1')continue;
                bfs(grid,i,j);
                nums++;
            }
        }
        return nums;
    }
    private void bfs(char[][] grid,int i,int j){
        if(i<0||i>grid.length-1||j<0||j>grid[0].length-1||grid[i][j]!='1')
            return;
        grid[i][j]='2';
        bfs(grid,i+1,j);
        bfs(grid,i-1,j);
        bfs(grid,i,j+1);
        bfs(grid,i,j-1);
    }
}
