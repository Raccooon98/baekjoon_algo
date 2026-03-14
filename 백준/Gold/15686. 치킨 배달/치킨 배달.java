import java.util.*;
import java.io.*;

public class Main {
    static int N, M, size, min = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[] vis;
    static Coord[] chicken, house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        ArrayList<Coord> temp = new ArrayList<>();
        ArrayList<Coord> temp2 = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    temp.add(new Coord(i, j));
                } else if (board[i][j] == 1) {
                    temp2.add(new Coord(i, j));
                }
            }
        }
        chicken = temp.toArray(new Coord[0]);
        house = temp2.toArray(new Coord[0]);
        size = chicken.length;
        vis = new boolean[size];

        DFS(0, 0, new ArrayList<>());

        System.out.println(min);
    }

    static void DFS(int cur, int depth, ArrayList<Integer> list) {
        if (depth == M) {
            int tmp = calDist(list);
            min = Math.min(min, tmp);
            return;
        }

        for (int i = cur; i < size; i++) {
            if (vis[i]) continue;

            vis[i] = true;
            list.add(i);
            DFS(i + 1, depth + 1, list);
            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }

    static int calDist(ArrayList<Integer> list) {
        int sum = 0;

        for (Coord cur : house) {
            int mindist = Integer.MAX_VALUE;
            for (int next : list) {
                Coord store = chicken[next];
                int dist = Math.abs(cur.x - store.x) + Math.abs(cur.y - store.y);
                mindist = Math.min(mindist, dist);
            }
            sum += mindist;
        }
        return sum;
    }

    static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
