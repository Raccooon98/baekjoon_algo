//그냥 DFS 시도해보기
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, startNode, endNode;
    static ArrayList<Node> adj[];
    static int Maxweight = Integer.MIN_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            adj[A].add(new Node(B, C));
            adj[B].add(new Node(A, C));
            Maxweight = Math.max(Maxweight, C);
        }

        st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = Maxweight;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            visited = new boolean[N + 1];
            if (DFS(startNode, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean DFS(int cur, int weight) {
        if (cur == endNode) {
            return true;
        }

        visited[cur] = true;

        for (Node next : adj[cur]) {
            if (!visited[next.to] && next.weight >= weight) {
                if (DFS(next.to, weight)) {
                    return true;
                }
            }
        }


        return false;
    }

    private static class Node {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
