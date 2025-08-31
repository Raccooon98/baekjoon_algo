import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer> adj[];
    static int N;
    static int board[][];
    public static void main(String args[])throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        adj=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1)
                    adj[i].add(j);
            }
        }

        for(int i=0;i<N;i++){
            boolean[] vis = new boolean[N];
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nxt : adj[cur]) {
                    if (!vis[nxt]) {
                        vis[nxt] = true;
                        board[i][nxt] = 1; // i에서 nxt까지 갈 수 있다
                        q.add(nxt);
                    }
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
