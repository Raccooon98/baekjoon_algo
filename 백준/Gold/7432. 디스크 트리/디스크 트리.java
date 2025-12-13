import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] arr = s.split("\\\\");
            trie.insert(arr);
        }

        trie.trieToString();

        System.out.println(sb.toString());
    }

    static void DFS(Node node, int depth) {
        List<String> keys = new ArrayList<>(node.child.keySet());
        Collections.sort(keys);

        for (String key : keys) {
                for (int i = 0; i < depth; i++) {
                    sb.append(" ");
                }
                sb.append(key).append("\n");

                DFS(node.child.get(key), depth + 1);

        }
    }

    private static class Node {
        Map<String, Node> child = new HashMap<>();

        public Node() {
            child = new HashMap<>();
        }
    }

    private static class Trie {
        Node root = new Node();

        public void insert(String[] arr) {
            Node tempNode = root;

            for (int i = 0; i < arr.length; i++) {
                String s = arr[i];

                tempNode = tempNode.child.computeIfAbsent(s, c -> new Node());
            }

        }

        public void trieToString() {
            DFS(root, 0);
        }
    }
}
