package leetcode;

import java.util.HashSet;

/**
 * Created by liucong on 2017/5/10.
 */
public class No36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!='.'&&!helper(board,i,j,board[i][j])){
                        return false;
                }
            }
        }
        return true;
    }
    public boolean helper(char[][] board,int row,int col,char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col]!='.'&&i!=row&&board[i][col]==c) return false;
            if(board[row][i]!='.'&&i!=col&&board[row][i]==c) return false;
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&((3 * (row / 3) + i / 3)!=row&&(3 * (col / 3) + i % 3)!=col)
                    &&board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                ".87654321".toCharArray(),
                "2........".toCharArray(),
                "3........".toCharArray(),
                "4........".toCharArray(),
                "5........".toCharArray(),
                "6........".toCharArray(),
                "7........".toCharArray(),
                "8........".toCharArray(),
                "9........".toCharArray(),
        };
        No36ValidSudoku test = new No36ValidSudoku();

        System.out.println(test.isValidSudoku(board));
    }
    public boolean isValidSudokuu(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        HashSet<Character> s =  new HashSet<Character>();
        for (int i = 0; i < row; i++) {
            s.clear();
            for (int j = 0; j < col; j++) {
                if(board[i][j]!='.'){
                    if(s.contains(board[i][j])) return false;
                    else s.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < col; i++) {
            s.clear();
            for (int j = 0; j < row; j++) {
                if(board[j][i]!='.'){
                    if(s.contains(board[j][i])) return false;
                    else s.add(board[j][i]);
                }
            }
        }
        for (int i = 0; i < row; i+=3) {
            for (int j = 0; j < col; j+=3) {
                s.clear();
                for(int a = 0; a < 3; a++)
                    for(int b= 0; b < 3; b++) {
                        if(board[i+a][j+b]!='.'){
                            if(s.contains(board[i+a][j+b])) return false;
                            else s.add(board[i+a][j+b]);
                        }
                    }

            }
        }
        return true;
    }
}
