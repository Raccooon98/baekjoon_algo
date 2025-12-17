import java.io.*;
import java.util.*;
import java.util.function.DoublePredicate;

public class Main {
    static int[] board;
    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];

        DFS(0);
        System.out.println(count);
    }

    private static void DFS(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[depth] = i;
            if (check(depth)) {
                DFS(depth + 1);
            }
        }
    }

    private static boolean check(int n) {
        for (int i = 0; i < n; i++) {
            if (board[n] == board[i] || Math.abs(n - i) == Math.abs(board[i] - board[n])) {
                return false;
            }
        }

        return true;
    }
}
