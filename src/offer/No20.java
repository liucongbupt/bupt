package offer;

/**
 * @author liucong
 * @ClassName: No20
 * @Description:
 * @date 2017年03月31日 下午3:27
 **/
public class No20 {
    private void printMatrixClockwisely(int[][] nums,int cols,int rows){
        if(nums==null||cols<0||rows<0)
            return;

        int start = 0;
        while(cols>2*start&&rows>2*start){
            printMatrixInCircle(nums,cols,rows,start);
            start++;
        }
    }
    
    private void printMatrixInCircle(int[][] nums,int cols,int rows,int start){
        int endX = cols-1-start;
        int endY = rows-1-start;
        
        //from left to right
        for (int i = start; i <= endX; i++) {
            System.out.print(nums[start][i]+" ");
        }

        if (start<endY){
            for (int i = start+1; i <= endY; i++) {
                System.out.print(nums[i][endX]+" ");
            }
        }

        if(start<endX&&start<endY){
            for (int i = endX-1; i >= start; i--) {
                System.out.print(nums[endY][i]+" ");
            }
        }
        if(start<endX&&start<endY-1){
            for (int i = endY-1; i >= start +1; i--) {
                System.out.print(nums[i][start]+" ");
            }
        }


    }
}
