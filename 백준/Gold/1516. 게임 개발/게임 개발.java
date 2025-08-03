import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] cost;
    static int[] inDegree;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cost = new int[N + 1];
        inDegree = new int[N + 1];
        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int pre = Integer.parseInt(st.nextToken());
                if (pre == -1)
                    break;
                else {
                    adj[pre].add(i);
                    inDegree[i]++;
                }
            }
        }


        Queue<Integer> q = new LinkedList<>();
        int[] resultTime = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                resultTime[i] = cost[i];
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : adj[current]) {
                resultTime[next] = Math.max(resultTime[next], resultTime[current] + cost[next]);

                inDegree[next]--;

                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(resultTime[i]);
        }
    }
}