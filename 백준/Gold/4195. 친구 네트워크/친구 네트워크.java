//그래프 순회 문제 -> 처음생긴 네트워크에 독립적인 네트워크가 합쳐지는 부분을 잘 인지하기
//생각해보니까 그냥 유니온파인드하면 해결 가능할듯
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[] parent;
    static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        int idx = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int t = 0; t < T; t++) {

            int F = Integer.parseInt(br.readLine());

            parent = new int[F*2];
            level = new int[F*2];

            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
                level[i] = 1;
            }

            for (int i = 0; i < F; i++) {

                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) {
                    map.put(a, idx++);
                }
                if (!map.containsKey(b)) {
                    map.put(b, idx++);
                }

                sb.append(union(map.get(a), map.get(b)) + "\n");

            }
        }

        System.out.println(sb);
    }

    private static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
            level[a] += level[b];//네트워크 규모 합치기

            level[b] = 1;
        }

        return level[a];
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
