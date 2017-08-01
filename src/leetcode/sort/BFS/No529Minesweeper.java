package leetcode.sort.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: No529Minesweeper
 * @Description:
 * @date 2017年03月26日 上午11:52
 **/
public class No529Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            if (board[r][c] == 'M') {
                board[r][c] = 'X';
                return board;
            } else {
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if(i==0&&j==0) continue;
                        int m = r + i;
                        int n = c + j;
                        if (m < 0 || m > board.length - 1 || n < 0 || n > board[0].length - 1)
                            continue;
                        if (board[m][n] == 'M'||board[m][n]=='X') {
                            count++;
                        }
                    }
                }


                if(count>0){
                    board[r][c]=(char) ('0' + count);
                }else{
                    board[r][c]='B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if(i==0&&j==0) continue;
                            int m = r + i;
                            int n = c + j;
                            if (m < 0 || m > board.length - 1 || n < 0 || n > board[0].length - 1)
                                continue;
                            if (board[m][n] == 'E') {
                                queue.add(new int[]{m,n});
                            }
                        }
                    }
                }
            }
        }
        return board;
}


    public static void main(String[] args) {

        No529Minesweeper test = new No529Minesweeper();
        char[][] a = new char[][]{"EEEEE".toCharArray(), "EEMEE".toCharArray(), "EEEEE".toCharArray(), "EEEEE".toCharArray()};
        int[] click = new int[]{3, 0};
        a = test.updateBoard(a, click);
        System.out.println(a.length);
        System.out.println(a[0].length);
    }
}
