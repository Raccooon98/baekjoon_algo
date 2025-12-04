import java.io.*;
import java.util.*;

public class Main {
    static int N, ans = 0;
    static ArrayList<Integer>[] tree;
    static boolean[] isDeleted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        isDeleted = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == -1) root = i;
            else tree[n].add(i);
        }

        int D = Integer.parseInt(br.readLine());

        removeNode(D);
        countNode(root);

        System.out.println(ans);
    }

    static void removeNode(int n) {
        isDeleted[n] = true;
        for (int next : tree[n]) {
            removeNode(next);
        }
    }

    static void countNode(int node) {
        if(isDeleted[node]){
            return;
        }

        boolean isLeaf = true;
        for(int cur: tree[node]){
            if(!isDeleted[cur]){
                isLeaf=false;
                countNode(cur);
            }
        }

        if(isLeaf)
            ans++;
    }
}
