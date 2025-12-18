//제일 긴 변을 따라가는 방향으로 모양 유추 가능
import java.util.*;
import java.io.*;

public class Main {
    static int[][] records = new int[6][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        int maxW = 0, maxH = 0;
        int wIdx = -1, hIdx = -1;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            records[i][0] = Integer.parseInt(st.nextToken());
            records[i][1] = Integer.parseInt(st.nextToken());

            int dir = records[i][0];
            int len = records[i][1];


            if ((dir == 1 || dir == 2) && len > maxW) {
                maxW = len;
                wIdx = i;
            } else if ((dir == 3 || dir == 4) && len > maxH) {
                maxH = len;
                hIdx = i;
            }
        }

        int smallW = Math.abs(records[(wIdx + 5) % 6][1] - records[(wIdx + 1) % 6][1]);
        int smallH = Math.abs(records[(hIdx + 5) % 6][1] - records[(hIdx + 1) % 6][1]);

        int ans = maxW * maxH - smallW * smallH;

        System.out.println(ans*K);
    }
}
