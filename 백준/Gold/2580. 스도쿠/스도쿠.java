import java.io.*;
import java.util.*;

public class Main {
    static int board[][] = new int[9][9];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
    }

    private static boolean solve(int row, int col) {
        if (col == 9) {
            return solve(row + 1, 0);
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        if (board[row][col] != 0) {
            return solve(row, col + 1);
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                if (solve(row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }

        return false;
    }

    private static boolean isValid(int row, int col, int num) {
        // 가로 검사
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // 세로 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // 3x3 박스 검사
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}