import java.io.*;
import java.util.*;

public class Main {
    static TrieNode root = new TrieNode();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TrieNode trie = new TrieNode();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            String[] temp = new String[K];

            for (int j = 0; j < K; j++) {
                temp[j] = st.nextToken();
            }

            trie.insert(temp);
        }

        trie.search();

        System.out.println(sb.toString());
    }

    static void DFS(TrieNode node, int depth) {
        List<String> keys = new ArrayList<>(node.child.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            for (int i = 0; i < depth; i++) {
                sb.append("--");
            }
            sb.append(key).append("\n");

            DFS(node.child.get(key), depth + 1);
        }
    }

    private static class TrieNode {
        Map<String, TrieNode> child;

        public TrieNode() {
            child = new HashMap<>();
        }

        public void insert(String[] arr) {
            TrieNode temp = root;

            for (int i = 0; i < arr.length; i++) {
                String s = arr[i];

                temp = temp.child.computeIfAbsent(s, c -> new TrieNode());
            }
        }

        public void search() {
            DFS(root,0);
        }
    }
}
