import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int[] colors = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        paper = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        makePaper(0, 0, N);

        for (int n : colors) {
            sb.append(n).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void makePaper(int x, int y, int n) {
        int color = paper[x][y];
        boolean check = true;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[i][j] != color) check = false;
            }
        }

        if (check) {
            colors[color]++;
            return;
        } else {
            makePaper(x, y, n / 2);
            makePaper(x + n / 2, y, n / 2);
            makePaper(x, y + n / 2, n / 2);
            makePaper(x + n / 2, y + n / 2, n / 2);
        }
    }
}
