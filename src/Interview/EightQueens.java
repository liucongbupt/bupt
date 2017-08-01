package Interview;

import java.io.Console;

/**
 * @author liucong
 * @ClassName: Interview.EightQueens
 * @Description: 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
 * 即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 * 下面使用递归方法解决
 * @date 2017年04月16日 下午9:01
 **/
public class EightQueens {
    public static int num = 0;
    public static final int MAXQUEEN = 8;
    public static int[] rows = new int[MAXQUEEN];

    public void getArrangement(int n) {
        if (n==MAXQUEEN){
            num++;
            printChessBoard();
            return;
        }
        for (int i = 0; i < MAXQUEEN; i++) {
            rows[n]=i;
            if (isSafe(n)){
                getArrangement(n+1);
            }
        }

    }

    public boolean isSafe(int n) {
        for (int i = 0; i < n; i++) {
            if (rows[i] == rows[n] || Math.abs(n - i) == Math.abs(rows[n] - rows[i])) {
                return false;
            }
        }
        return true;
    }

    public void printChessBoard() {
        System.out.println("*********************");
        System.out.println("No. " + num + "  Arrangement");
        System.out.println();
        for (int i = 0; i < MAXQUEEN; i++) {
            for (int j = 0; j < MAXQUEEN; j++) {
                if (i == rows[j]) {
                    System.out.print("0");
                } else {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EightQueens test = new EightQueens();
        test.getArrangement(0);
        System.out.println();
        System.out.println("Total:" + num);
    }
}
