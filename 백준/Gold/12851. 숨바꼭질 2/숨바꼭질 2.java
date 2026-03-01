import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dist = new int[100002];
    static int[] cnt = new int[100002];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        if (n == k) {
            System.out.println("0\n1");
            return;
        }

        Arrays.fill(dist, -1);
        dist[n] = 0;
        cnt[n] = 1;
        q.add(n);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nx : new int[]{cur + 1, cur - 1, cur * 2}) {
                if (nx < 0 || nx > 100000) continue;
                if (dist[nx] != -1) { // Already visited
                    if (dist[cur] + 1 == dist[nx]) // Same shortest distance
                        cnt[nx] += cnt[cur];
                } else { // First visit
                    dist[nx] = dist[cur] + 1; // Update shortest distance
                    cnt[nx] = cnt[cur];
                    q.add(nx);
                }
            }
        }

        System.out.println(dist[k]);
        System.out.println(cnt[k]);
    }
}
