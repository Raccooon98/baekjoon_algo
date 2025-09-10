import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int board[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            char c[] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(c[j]));
            }
        }
        quadTree(0, 0, N);
        System.out.println(sb);
    }

    private static void quadTree(int x, int y, int size) {
        if (isSame(x, y, size)) {
            sb.append(board[x][y]);
            return;
        }

        sb.append("(");
        int nextSize = size / 2;
        quadTree(x, y, nextSize);
        quadTree(x, y + nextSize, nextSize);
        quadTree(x + nextSize, y, nextSize);
        quadTree(x + nextSize, y + nextSize, nextSize);
        sb.append(")");
    }

    //구역이 전부 같은 색인지 확인 하기
    private static boolean isSame(int x, int y, int size) {
        int color = board[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
