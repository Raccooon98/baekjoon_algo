import java.io.*;
import java.util.*;

public class Main {
    private static int[] input = new int[9];
    private static int[] temp = new int[7];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        DFS(0, 0);

        System.out.println(sb.toString());
    }

    private static void DFS(int depth, int cur) {
        if (depth >= 7) {
            int sum = 0;
            for (int n : temp) {
                sum += n;
            }
            if (sum == 100) {
                for (int n : temp) {
                    sb.append(n).append("\n");
                }
            }
            return;
        }

        for (int i = cur; i < 9; i++) {
            temp[depth] = input[i];
            DFS(depth + 1, i + 1);
        }
    }
}
