package offer;

/**
 * @author liucong
 * @ClassName: No66
 * @Description:
 * @date 2017年04月05日 下午2:43
 **/
public class No66 {
    public static boolean hasPath(char[] matrix,int rows,int cols,char[] str){
        if (matrix==null||str==null||rows<1||cols<1)
            return false;
        boolean[][] visited = new boolean[rows][cols];
        int[] pathLength = {0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix,rows,cols,str,i,j,pathLength,visited))
                    return true;
            }
        }
        return false;
    }
    public static boolean hasPathCore(char[] matrix,int rows,int cols,char[] str,int i,int j,int[] pathLength,boolean[][] visited){
        if (pathLength[0]==str.length)
            return true;
        boolean hasPath = false;
        if (i>=0&&i<rows&&j>=0&&j<cols&&matrix[i*cols+j]==str[pathLength[0]]&&!visited[i][j]){
            pathLength[0]++;
            visited[i][j]=true;
            hasPath=hasPathCore(matrix,rows,cols,str,i+1,j,pathLength,visited)||
                    hasPathCore(matrix,rows,cols,str,i-1,j,pathLength,visited)||
                    hasPathCore(matrix,rows,cols,str,i,j+1,pathLength,visited)||
                    hasPathCore(matrix,rows,cols,str,i,j-1,pathLength,visited);
            if (!hasPath){
                pathLength[0]--;
                visited[i][j]=false;
            }
        }
        return hasPath;
    }
    public static void main(String[] args) {
        //ABCE  //ABCCED
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "ABCCED".toCharArray()) + "[true]");// true

        //ABCE  //SEE
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "SEE".toCharArray()) + "[true]");// true

        //ABCE  //ABCB
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "ABCB".toCharArray()) + "[false]");// false

        //ABCEHJIG  //SLHECCEIDEJFGGFIE
        //SFCSLOPQ
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SLHECCEIDEJFGGFIE".toCharArray()) + "[true]");// true


        //ABCEHJIG  //SGGFIECVAASABCEHJIGQEM
        //SFCSLOPQ  //
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SGGFIECVAASABCEHJIGQEM".toCharArray()) + "[true]");// true

        //ABCEHJIG  //SGGFIECVAASABCEEJIGOEM
        //SFCSLOPQ
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SGGFIECVAASABCEEJIGOEM".toCharArray()) + "[false]");// false


        //ABCEHJIG  //SGGFIECVAASABCEHJIGQEMS
        //SFCSLOPQ
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SGGFIECVAASABCEHJIGQEMS".toCharArray()) + "[false]");// false

        //AAAA  //AAAAAAAAAAAA
        //AAAA
        //AAAA
        System.out.println(hasPath("AAAAAAAAAAAA".toCharArray(), 3, 4,
                "AAAAAAAAAAAA".toCharArray()) + "[true]");// true

        //AAAA  //AAAAAAAAAAAAA
        //AAAA
        //AAAA
        System.out.println(hasPath("AAAAAAAAAAAA".toCharArray(), 3, 4,
                "AAAAAAAAAAAAA".toCharArray()) + "[false]");// false

    }
}
