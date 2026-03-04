import java.util.*;
import java.io.*;

public class Main {
    static int N, M, D;
    static int max = 0;
    static int[][] board;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        vis = new boolean[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0, new ArrayList<>());

        System.out.println(max);
    }

    //조합으로 3자리 선정
    static void DFS(int cur, int depth, List<Integer> list) {
        if (depth >= 3) {
            int num = castleDefense(list);
            max = Math.max(max, num);
            return;
        }

        for (int i = cur; i < M; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            list.add(i);
            DFS(i + 1, depth + 1, list);
            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }

    //만들어진 조합으로 캐슬디펜스 후 결과를 출력
    static int castleDefense(List<Integer> list) {
        int count = 0;
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            temp[i] = board[i].clone();
        }

        for (int turn = 0; turn < N; turn++) {
            List<int[]> targets = new ArrayList<>();

            for (int archerCol : list) {
                int minD = D + 1;
                int targetR = -1;
                int targetC = -1;

                for (int j = 0; j < M; j++) {
                    for (int i = N - 1; i >= 0; i--) {
                        if (temp[i][j] == 1) {
                            int dist = Math.abs(N - i) + Math.abs(archerCol - j);
                            if (dist <= D) {
                                if (dist < minD) {
                                    minD = dist;
                                    targetR = i;
                                    targetC = j;
                                }
                            }
                        }
                    }
                }

                if (targetR != -1) {
                    targets.add(new int[]{targetR, targetC});
                }
            }

            for (int[] target : targets) {
                if (temp[target[0]][target[1]] == 1) {
                    temp[target[0]][target[1]] = 0;
                    count++;
                }
            }

            for (int i = N - 1; i > 0; i--) {
                temp[i] = temp[i - 1].clone();
            }
            temp[0] = new int[M]; // 맨 윗줄은 빈 칸이 됨
        }

        return count;
    }
}
