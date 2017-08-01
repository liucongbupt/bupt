package offer;

/**
 * @author liucong
 * @ClassName: No67
 * @Description:
 * @date 2017年04月05日 下午2:43
 **/
public class No67 {
    public static int movingCount(int threshold,int rows,int cols){
        if (threshold<0||rows<1||cols<1)
            return 0;

        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold,rows,cols,0,0,visited);
    }
    public static int movingCountCore(int threshold,int rows,int cols,int row,int col,boolean[][] visited){
        int count = 0;
        if (check(threshold,rows,cols,row,col,visited)){
            visited[row][col]= true;
            count = 1
                    + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }
    private static boolean check(int threshold,int rows,int cols,int row,int col,boolean[][] visited){
        return col>=0&&col<cols&&row>=0&&row<rows&&!visited[row][col]&&(getDigitSum(row)+getDigitSum(col)<=threshold);
    }
    private static int getDigitSum(int number){
        int rtn = 0;
        while (number>0){
            rtn+=number%10;
            number/=10;
        }
        return rtn;
    }
    public static void main(String[] args) {
        System.out.println(movingCount(5, 10, 10) + "[21]");
        System.out.println(movingCount(15, 20, 20) + "[359]");
        System.out.println(movingCount(10, 1, 100) + "[29]");
        System.out.println(movingCount(10, 1, 10) + "[10]");
        System.out.println(movingCount(15, 100, 1) + "[79]");
        System.out.println(movingCount(15, 10, 1) + "[10]");
        System.out.println(movingCount(5, 10, 10) + "[21]");
        System.out.println(movingCount(12, 1, 1) + "[1]");
        System.out.println(movingCount(-10, 10, 10) + "[0]");
    }
}
