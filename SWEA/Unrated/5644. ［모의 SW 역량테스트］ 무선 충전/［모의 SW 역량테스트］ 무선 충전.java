import java.io.*;
import java.util.*;

public class Solution {
    static int[][] people;
    static Charger[] chargers;
    // 특정 좌표에서 접근 가능한 충전기 인덱스 리스트
    static ArrayList<Integer>[][] board;
    static Coord[] coords;

    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static int ans;
    static int M, A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            ans = 0;
            board = new ArrayList[11][11];
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    board[i][j] = new ArrayList<>();
                }
            }

            people = new int[2][M + 1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 1; m <= M; m++) {
                    people[i][m] = Integer.parseInt(st.nextToken());
                }
            }

            chargers = new Charger[A];
            for (int a = 0; a < A; a++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                chargers[a] = new Charger(x, y, c, p);

                // BC 영향 범위 미리 기록
                fillBoard(a);
            }

            coords = new Coord[2];
            coords[0] = new Coord(1, 1);
            coords[1] = new Coord(10, 10);


            for (int i = 0; i <= M; i++) {

                for (int p = 0; p < 2; p++) {
                    int move = people[p][i];
                    coords[p].x += dx[move];
                    coords[p].y += dy[move];
                }

                ans += getMaxCharge();
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }


    static void fillBoard(int idx) {
        Charger bc = chargers[idx];
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                int dist = Math.abs(bc.x - i) + Math.abs(bc.y - j);
                if (dist <= bc.C) {
                    board[i][j].add(idx);
                }
            }
        }
    }


    static int getMaxCharge() {
        int max = 0;
        List<Integer> listA = board[coords[0].x][coords[0].y];
        List<Integer> listB = board[coords[1].x][coords[1].y];


        int sizeA = listA.size();
        int sizeB = listB.size();

        if (sizeA == 0 && sizeB == 0) return 0;


        if (sizeB == 0) {
            for (int aIdx : listA) max = Math.max(max, chargers[aIdx].P);
        } else if (sizeA == 0) {
            for (int bIdx : listB) max = Math.max(max, chargers[bIdx].P);
        } else {
            for (int aIdx : listA) {
                for (int bIdx : listB) {
                    int sum = 0;
                    if (aIdx == bIdx) {
                        // 같은 BC를 사용하면 나눠가지므로 결국 P와 같음
                        sum = chargers[aIdx].P;
                    } else {
                        sum = chargers[aIdx].P + chargers[bIdx].P;
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    static class Charger {
        int x, y, C, P;

        public Charger(int x, int y, int C, int P) {
            this.x = x;
            this.y = y;
            this.C = C;
            this.P = P;
        }
    }

    static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}