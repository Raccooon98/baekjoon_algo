//모든 별들은 별자리 위의 선을 통해 서로 직/간접적으로 이어져 있어야 한다. -> MST 냄새남 크루스칼 시도해보기
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Coord stars[];
    static int parent[];
    static float ans = 0;
    static ArrayList<Node> adj;
    static int cnt = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        stars = new Coord[N];
        parent = new int[N];
        adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            float x = Float.parseFloat(st.nextToken());
            float y = Float.parseFloat(st.nextToken());

            stars[i] = new Coord(x, y);
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                adj.add(new Node(i,j,calDist(stars[i],stars[j])));
            }
        }

        Collections.sort(adj);

        kruskal();

        ans = (float)Math.round(ans * 100) /100.0f;
        System.out.println(ans);
    }

    public static void union(Node node) {
        int startParent = find(node.from);
        int endParent = find(node.to);

        if(startParent == endParent) //부모가 같으면 연결
            return;
        else if(startParent<endParent) {
            parent[endParent] = startParent;
        } else {
            parent[startParent] = endParent;
        }
        ans+= node.dist;
        cnt++;
    }

    public static int find(int p) {
        if(parent[p]==p)
            return p;
        return parent[p]= find(parent[p]);
    }

    public static void kruskal() {
        for(int i=0;i<adj.size();i++) {
            if(cnt==N-1)
                break;
            union(adj.get(i));
        }
    }

    private static float calDist(Coord a, Coord b){
        return (float)Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
    }

    private static class Coord {
        float x, y;

        public Coord(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node implements Comparable<Node> {
        int from, to;
        float dist;

        public Node(int from, int to, float dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Float.compare(this.dist, o.dist);
        }
    }
}
