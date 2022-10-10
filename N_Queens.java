import java.util.*;

public class N_Queens {

    static boolean validate(int row, int column, char[][] board) {
        int duprow = row;
        int dupcolumn = column;
        while (row >= 0 && column >= 0) {
            if (board[row][column] == 'Q')
                return false;
            row--;
            column--;
        }
        row = duprow;
        column = dupcolumn;
        while (column >= 0) {
            if (board[row][column] == 'Q')
                return false;
            column--;
        }
        row = duprow;
        column = dupcolumn;
        while (column >= 0 && row<board.length) {
            if (board[row][column] == 'Q')
                return false;
            column--;
            row++;
        }
        return true;
    }

    static ArrayList<String> construct(char[][] board) {
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    static void findArrangement(int column, char[][] board, ArrayList<ArrayList<String>> res) {
        if (column == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(row, column, board)) {
                board[row][column] = 'Q';
                findArrangement(column + 1, board, res);
                board[row][column] = '.';
            }
        }
    }

    static ArrayList<ArrayList<String>> solve_Queens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        findArrangement(0, board, res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<String>> queen = solve_Queens(n);
        int i = 1;
        for (ArrayList<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }
}