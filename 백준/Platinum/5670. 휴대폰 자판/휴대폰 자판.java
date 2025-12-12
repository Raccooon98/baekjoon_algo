import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while ((str = br.readLine()) != null && !str.isEmpty()) {

            Trie trie = new Trie();

            int N = Integer.parseInt(str);
            String[] words = new String[N];

            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
                trie.insert(words[i]);
            }

            int sum = 0;

            for (String w : words) {
                sum += trie.numOfButton(w);
            }

            float avg = ((float)sum / (float) N);

            sb.append(String.format("%.2f\n", avg));
        }
        System.out.println(sb);
    }

    private static class Node {
        Map<Character, Node> child = new HashMap<>();
        boolean isLast;

        public Node() {
            child = new HashMap<>();
            isLast = false;
        }

        public int getChildCount() {
            return child.size();
        }
    }

    private static class Trie {
        Node root = new Node();

        public void insert(String str) {
            Node temp = root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                temp = temp.child.computeIfAbsent(c, k -> new Node());
            }

            temp.isLast = true;
        }

        public int numOfButton(String str) {
            int count = 0;
            Node temp = root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                Node node = temp.child.get(c);
                if (node == null) break;

                if (i == 0 || temp.isLast || temp.child.size() > 1) {
                    count++;
                }

                temp = node;
            }

            return count;
        }
    }
}
