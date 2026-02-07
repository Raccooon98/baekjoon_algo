import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    static int N;
    static boolean[] vis = new boolean[10];
    static boolean[] base;
    static int[] selected = new int[10];
    static int[][] player;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        player = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected[4] = 1;

        pick(1);
        System.out.println(ans);
    }

    static void pick(int depth) {
        if (depth == 10) {
            baseball();
            return;
        }

        if (depth == 4) {
            pick(depth + 1);
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            selected[depth] = i;
            pick(depth + 1);
            vis[i] = false;
        }
    }

    static void baseball() {
        int inning = 1;
        int cur = 1;
        int score = 0;

        while (inning <= N) {
            int out = 0;
            //이닝마다 베이스 초기화
            base = new boolean[3];

            while (out < 3) {
                if (player[inning][selected[cur]] == 0) {
                    out++;
                } else {
                    score += play(player[inning][selected[cur]]);
                }

                if (cur == 9) {
                    cur = 1;
                } else {
                    cur++;
                }
            }
            inning++;
        }

        ans = Math.max(ans, score);
    }

    static int play(int check) {
        int score = 0;

        if (check == 1) {
            if (base[2]) score++;
            base[2] = base[1];
            base[1] = base[0];
            base[0] = true;
        } else if (check == 2) {
            for (int i = 2; i >= 1; i--) {
                if (base[i]) {
                    score++;
                    base[i] = false;
                }
            }
            base[2] = base[0];
            base[1] = true;
            base[0] = false;
        } else if (check == 3) {
            for (int i = 2; i >= 0; i--) {
                if (base[i]) {
                    score++;
                    base[i] = false;
                }
            }
            base[2] = true;
        } else {
            for (int i = 2; i >= 0; i--) {
                if (base[i]) {
                    score++;
                    base[i] = false;
                }
            }
            score++;
        }
        return score;
    }
}
