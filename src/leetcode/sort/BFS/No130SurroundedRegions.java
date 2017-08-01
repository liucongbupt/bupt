package leetcode.sort.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: No130SurroundedRegions
 * @Description:
 * @date 2017年03月22日 下午10:52
 **/
public class No130SurroundedRegions {
    public void solve(char[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            bfs(board, 0, i);
            bfs(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                    break;
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                    break;

                }
            }
        }

    }

    private void bfs(char[][] board, int o, int p) {
        int m = board.length;
        int n = board[0].length;

        if (board[o][p] != 'O') return;

        board[o][p] = '#';

        int index = o * n + p;
        Queue<Integer> q = new LinkedList<>();
        q.add(index);

        while (!q.isEmpty()) {

            int top = q.poll();
            int i = top / n;
            int j = top % n;

            if ((i - 1) >= 0 && board[i - 1][j] == 'O') {
                q.add((i - 1) * n + j);
                board[i - 1][j] = '#';
            }
            if ((i + 1) <= (m-1) && board[i + 1][j] == 'O') {
                q.add((i + 1) * n + j);
                board[i + 1][j] = '#';
            }
            if ((j - 1) >= 0 && board[i][j - 1] == 'O') {
                q.add(i * n + j - 1);
                board[i][j - 1] = '#';
            }
            if ((j + 1) <= n-1 && board[i][j + 1] == 'O') {
                q.add(i * n + j + 1);
                board[i][j + 1] = '#';
            }

        }
    }
}
