//1000000000 -> 111011100110101100101000000000(2)
//최대 30자리 이진수임
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int MaxHeight = 30;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        List<Integer> input = new ArrayList<>();

        Node trie = new Node();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            input.add(num);
            trie.insert(num);
        }

        int max = -1;
        for (int n : input) {
            max = Math.max(max, trie.getXor(n));
        }

        System.out.println(max);
    }

    private static class Node {
        Node[] child;

        public Node() {
            child = new Node[2];
        }

        public void insert(int val) {
            Node cur = this;

            for (int i = MaxHeight; i >= 0; i--) {
                int status = val & (1 << i);
                int next = status == 0 ? 1 : 0;

                if (cur.child[next] == null) {
                    cur.child[next] = new Node();
                }

                cur = cur.child[next];
            }
        }

        public int getXor(int val) {
            Node cur = this;
            int res = 0;

            for (int i = MaxHeight; i >= 0; i--) {
                int status = val & (1 << i);
                int next = status == 0 ? 0 : 1;

                if (cur.child[next] == null) {
                    next = next == 0 ? 1 : 0;
                } else {
                    res += 1 << i;
                }

                cur = cur.child[next];
            }
            return res;
        }
    }
}
