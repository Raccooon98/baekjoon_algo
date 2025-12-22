import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            Queue<Info> q = new ArrayDeque<>();

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());

                q.offer(new Info(num, i));
            }
            int count = 1;
            while (!q.isEmpty()) {
                boolean canPrint = true;

                Info cur = q.poll();

                for (Info now : q) {
                    if (cur.val < now.val) {
                        canPrint = false;

                        q.offer(cur);
                        break;
                    }
                }
                if (canPrint) {
                    if (cur.idx == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                    count++;
                }
            }
        }

        System.out.println(sb.toString());
    }

    private static class Info {
        int val;
        int idx;

        public Info(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
