import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static ArrayList<Node>[] adj;
    static int N;
    static int Max = 0;
    static boolean[] visited;
    static int Max_idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; ++i) {
            adj[i] = new ArrayList<>();
        }

        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[parent].add(new Node(child,dist));
            adj[child].add(new Node(parent,dist));
        }

        visited[1]=true;
        DFS(1,0);

        Arrays.fill(visited,false);
        visited[Max_idx]=true;
        DFS(Max_idx,0);
        System.out.println(Max);
    }
    static void DFS(int idx,int cnt){
        if(Max<cnt){
            Max=cnt;
            Max_idx=idx;
        }

        for(Node a : adj[idx]){
            if(!visited[a.idx]){
                visited[a.idx]=true;
                DFS(a.idx,cnt+a.cnt);
            }
        }
    }

    static private class Node {
        int idx, cnt;

        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
