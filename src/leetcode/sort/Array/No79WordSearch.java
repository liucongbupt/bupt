package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No79WordSearch
 * @Description:
 * @date 2017年02月27日 下午5:08
 **/

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class No79WordSearch{
    int[] dh = {0, 1, 0, -1};  //检索方向[右,下,左,上]
    int[] dw = {1, 0, -1, 0};
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];  //访问标记
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (isThisWay(board, word, i, j, 0, isVisited)) return true;
        return false;
    }
    public boolean isThisWay(char[][] board, String word, int row, int column, int index, boolean[][] isVisited) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length
                || isVisited[row][column] || board[row][column] != word.charAt(index))
            return false;  //剪枝
        if (++index == word.length()) return true;  //word所有字符均匹配上
        isVisited[row][column] = true;
        for (int i = 0; i < 4; i++)
            if (isThisWay(board, word, row + dh[i], column + dw[i], index, isVisited))
                return true;  //以board[row][column]为起点找到匹配上word路径
        isVisited[row][column] = false;  //遍历过后，将该点还原为未访问过
        return false;
    }
}