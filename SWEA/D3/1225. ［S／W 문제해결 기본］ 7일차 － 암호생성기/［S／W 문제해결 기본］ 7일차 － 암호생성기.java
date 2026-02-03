import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            Deque<Integer> dq = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            }

            while (true) {
                boolean stop = false;
                for (int i = 1; i <= 5; i++) {
                    int cur = dq.pollFirst();

                    if (cur - i > 0) {
                        dq.addLast(cur - i);
                    } else {
                        dq.addLast(0);
                        stop = true;
                        break;
                    }
                }

                if (stop) break;
            }

            sb.append("#").append(t).append(" ");
            for (int n : dq) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }


        System.out.println(sb.toString());
    }
}
