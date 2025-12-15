//이 문제도 1000000000이니까 30자리 이진수까지 표현 가능
import java.io.*;
import java.util.*;

public class Main {
    static int maxHeight = 30;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Node trie = new Node();
        int M = Integer.parseInt(br.readLine());

        trie.insert(0);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                trie.insert(b);
            } else if (a == 2) {
                trie.delete(b);
            } else {
                sb.append(trie.searchXor(b)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static class Node {
        Node[] child;
        int count;

        public Node() {
            child = new Node[2];
        }

        public void insert(int val) {
            Node cur = this;
            cur.count++;

            for (int i = maxHeight; i >= 0; i--) {
                int next = (val >> i) & 1;

                if (cur.child[next] == null) {
                    cur.child[next] = new Node();
                }

                cur = cur.child[next];
                cur.count++;
            }
        }

        public int searchXor(int val) {
            Node cur = this;
            int sum = 0;

            for (int i = maxHeight; i >= 0; i--) {
                int next = (val >> i) & 1;
                int want = next ^ 1;

                if (cur.child[want] != null && cur.child[want].count > 0) {
                    sum |= 1 << i;
                    cur = cur.child[want];
                } else {
                    cur = cur.child[next];
                }
            }

            return sum;
        }

        public void delete(int val) {
            Node cur = this;
            cur.count--;

            for (int i = maxHeight; i >= 0; i--) {
                int next = (val >> i) & 1;
                cur = cur.child[next];
                cur.count--;
            }
        }
    }
}
