import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> tree[];
    static boolean remove_check[];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        tree = new ArrayList[N];
        remove_check = new boolean[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        int root = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == -1)
                root = i;
            else
                tree[num].add(i);
        }

        int D = Integer.parseInt(br.readLine());

        if (D == root) {
            System.out.println(0);
            System.exit(0);
        }

        removeNode(D);
        cntNode(root);

        System.out.println(cnt);
    }

    private static void removeNode(int d) {
        remove_check[d] = true;

        for (int cur : tree[d]) {
            removeNode(cur);
        }
    }

    private static void cntNode(int node) {
        if (remove_check[node]) {
            return;
        }

        boolean isleaf = true;
        for (int cur : tree[node]) {
            if (!remove_check[cur]) {
                isleaf = false;
                cntNode(cur);
            }
        }

        if (isleaf) {
            cnt++;
        }
    }
}
