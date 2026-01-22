import java.io.*;
import java.util.*;

public class Solution {
    private static int K;
    private static int[][] gears;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());
            gears = new int[4][8];

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    gears[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()) - 1; // 0~3 index
                int dir = Integer.parseInt(st.nextToken());

                int[] directions = new int[4];
                directions[num] = dir;

                // 오른쪽 방향 확인
                for (int j = num; j < 3; j++) {
                    if (gears[j][2] != gears[j + 1][6]) {
                        directions[j + 1] = -directions[j];
                    } else break;
                }
                // 왼쪽 방향 확인
                for (int j = num; j > 0; j--) {
                    if (gears[j][6] != gears[j - 1][2]) {
                        directions[j - 1] = -directions[j];
                    } else break;
                }

                // 2. 결정된 방향대로 모든 자석 회전
                for (int j = 0; j < 4; j++) {
                    if (directions[j] != 0) {
                        doRotate(j, directions[j]);
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < 4; i++) {
                if (gears[i][0] == 1) {
                    ans += Math.pow(2, i);
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }


    private static void doRotate(int idx, int dir) {
        if (dir == 1) { // 시계 방향
            int temp = gears[idx][7];
            for (int i = 7; i > 0; i--) {
                gears[idx][i] = gears[idx][i - 1];
            }
            gears[idx][0] = temp;
        } else { // 반시계 방향
            int temp = gears[idx][0];
            for (int i = 0; i < 7; i++) {
                gears[idx][i] = gears[idx][i + 1];
            }
            gears[idx][7] = temp;
        }
    }
}