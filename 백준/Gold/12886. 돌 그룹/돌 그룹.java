import java.io.*;
import java.util.*;

public class Main {
    static Queue<int[]> q;
    static boolean[][] visited;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if ((A + B + C) % 3 != 0) {
            System.out.println(0);
            return;
        }

        q = new LinkedList<>();
        visited = new boolean[1501][1501];

        q.offer(new int[]{A, B, C});
        visited[A][B] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int z = current[2];

            if (x == y && y == z) {
                System.out.println(1);
                return;
            }

            move(x, y, z);
            move(y, z, x);
            move(x, z, y);
        }

        System.out.println(0);
        br.close();
    }
    static void move(int stone1, int stone2, int stone3){
        int small, big;
        if (stone1 < stone2) {
            small = stone1;
            big = stone2;
        } else if (stone1 > stone2) {
            small = stone2;
            big = stone1;
        } else {
            return;
        }

        int newSmall = small * 2;
        int newBig = big - small;
        int tmp = stone3;

        int[] newState = {newSmall, newBig, tmp};
        Arrays.sort(newState);

        int s1 = newState[0];
        int s2 = newState[1];

        if (!visited[s1][s2]) {
            visited[s1][s2] = true;
            q.offer(newState);
        }
    }
}
