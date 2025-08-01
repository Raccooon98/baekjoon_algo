import java.util.*;
import java.io.*;
public class Main {

    static int[] parent;
    static List<int[]> Keys;
    static PriorityQueue<Node> nodes;
    static int N,M;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static char[][] Map;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new char[N][N];
        Keys = new ArrayList<>();
        nodes = new PriorityQueue<>();
        parent = new int[M+1];
        for(int i=0;i<=M;++i){
            parent[i]=i;
        }


        for(int i=0;i<N;++i){
            String s = br.readLine();
            for(int j=0;j<N;++j){
                Map[i][j]=s.charAt(j);
                if(Map[i][j]=='S'||Map[i][j]=='K'){
                    Keys.add(new int[] {i,j});
                }
            }
        }

        for(int i=0;i<Keys.size();i++){
            BFS(i);
        }
        System.out.println(kruskal());

    }

    static class Node implements Comparable<Node>{
        int  x,y,dist;

        Node(int x,int y, int dist){
            this.x=x;
            this.y=y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return dist-o.dist;
        }
    }

    private static class Coord{
        int x,y, movecount;

        public Coord(int x,int y, int movecount){
            this.x=x;
            this.y=y;
            this.movecount=movecount;
        }
    }

    static void union(int a,int b){
        int parentA = findParent(a), parentB = findParent(b);

        if(parentA!=parentB){
            if(parentA<parentB)
                parent[parentB] = parentA;
            else
                parent[parentA] = parentB;
        }
    }

    static int findParent(int a){
        if(a==parent[a]) return a;
        return parent[a] = findParent(parent[a]);
    }

    static boolean isSameParent(int a,int b){
        int parentA = findParent(a),parentB = findParent(b);
        return parentA == parentB;
    }

    static void BFS(int st) {
        Queue<Coord> q = new LinkedList<>();
        int[][] dist = new int[N][N]; // 거리 저장 배열
        for(int i=0; i<N; i++) Arrays.fill(dist[i], -1);

        int[] start = Keys.get(st);
        q.offer(new Coord(start[0], start[1], 0));
        dist[start[0]][start[1]] = 0;

        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int d=0;d<4;d++){
                int nx = cur.x+dx[d], ny = cur.y+dy[d];

                if(nx<0||nx>=N||ny<0||ny>=N) continue;
                if(Map[nx][ny]=='1' || dist[nx][ny] != -1) continue;

                dist[nx][ny] = cur.movecount+1;
                q.offer(new Coord(nx,ny,cur.movecount+1));
            }
        }

        // BFS가 끝난 후, 모든 열쇠에 대해 간선 생성
        for(int i=0; i<Keys.size(); i++){
            int[] keyPos = Keys.get(i);
            int distance = dist[keyPos[0]][keyPos[1]];
            if(distance != -1) {
                nodes.offer(new Node(st, i, distance));
            }
        }
    }

    static int kruskal(){
        int dist =0, count=0;
        while(!nodes.isEmpty()){
            Node node = nodes.poll();

            if(findParent(node.x)!=findParent(node.y)){
                union(node.x,node.y);
                dist+=node.dist;
                count++;
            }
        }
        if(count==M)
            return dist;
        else return -1;
    }


}
