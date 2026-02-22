import java.io.*;
import java.util.*;

public class Main {
    static int[][] country = new int[6][3];
    static int[][] matches = new int[15][2];
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                matches[idx][0] = i;
                matches[idx][1] = j;
                idx++;
            }
        }

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int totalMatchCount = 0;
            for (int n = 0; n < 6; n++) {
                country[n][0] = Integer.parseInt(st.nextToken());
                country[n][1] = Integer.parseInt(st.nextToken());
                country[n][2] = Integer.parseInt(st.nextToken());
                totalMatchCount += (country[n][0] + country[n][1] + country[n][2]);
            }

            isPossible = false;
            if (totalMatchCount == 30) {
                dfs(0);
            }

            sb.append(isPossible ? 1 : 0).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static void dfs(int matchIdx) {
        if (isPossible) return;

        if (matchIdx == 15) {
            isPossible = true;
            return;
        }

        int teamA = matches[matchIdx][0];
        int teamB = matches[matchIdx][1];

        // A가 이기고 B가 지는 경우
        if (country[teamA][0] > 0 && country[teamB][2] > 0) {
            country[teamA][0]--;
            country[teamB][2]--;
            dfs(matchIdx + 1);
            country[teamA][0]++;
            country[teamB][2]++;
        }

        //A와 B가 비기는 경우
        if (country[teamA][1] > 0 && country[teamB][1] > 0) {
            country[teamA][1]--;
            country[teamB][1]--;
            dfs(matchIdx + 1);
            country[teamA][1]++;
            country[teamB][1]++;
        }

        //A가 지고 B가 이기는 경우
        if (country[teamA][2] > 0 && country[teamB][0] > 0) {
            country[teamA][2]--;
            country[teamB][0]--;
            dfs(matchIdx + 1);
            country[teamA][2]++;
            country[teamB][0]++;
        }
    }
}