package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No289GameofLife
 * @Description:
 * @date 2017年02月28日 下午11:12
 **/

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * <p>
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all leetcode.Sort cases.
 * <p>
 * Subscribe to see which companies asked this question.
 * <p>
 * Hide Tags leetcode.Array
 * Hide Similar Problems (M) Set Matrix Zeroes
 */
public class No289GameofLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = countn(board, i, j);
                if (count == 3 || (count == 2 && board[i][j] == 1)) {
                    board[i][j] += 10;
                }
            }
        }
        flush(board);
    }

    public int countn(int[][] board, int r, int c) {
        int count = 0;
        for (int i = Math.max(r - 1, 0); i <= Math.min(r + 1, board.length - 1); i++) {
            for (int j = Math.max(c - 1, 0); j <= Math.min(c + 1, board[i].length - 1); j++) {
                if (i != r || j != c) {
                    count += board[i][j] % 10;
                }
            }
        }
        return count;
    }

    public void flush(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] =  board[i][j]/10;
            }
        }
    }


}
