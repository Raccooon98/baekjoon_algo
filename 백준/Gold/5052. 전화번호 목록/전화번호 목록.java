import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int T = 0; T < TC; T++) {
            Trie trie = new Trie();
            int N = Integer.parseInt(br.readLine());
            boolean isContain = false;
            List<String> keys = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                trie.insert(s);
            }

            sb.append(trie.isConsistent? "YES" : "NO").append("\n");
        }

        System.out.println(sb.toString());
    }

    private static class Node {
        HashMap<Character, Node> child;
        boolean isLastChar;

        public Node() {
            this.child = new HashMap<>();
            this.isLastChar = false;
        }

        public boolean isLastChar() {
            return this.isLastChar;
        }

        public void setLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }

        public Map<Character, Node> getChild() {
            return child;
        }
    }

    private static class Trie {
        Node root;
        boolean isConsistent = true;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String str) {
            Node tempNode = this.root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (tempNode.isLastChar) {
                    isConsistent = false;
                    return;
                }
                tempNode = tempNode.getChild().computeIfAbsent(c, k -> new Node());
            }

            if(!tempNode.child.isEmpty()){
                isConsistent = false;
            }

            tempNode.setLastChar(true);
        }

        boolean search(String str) {
            Node tempNode = this.root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                Node node = tempNode.getChild().get(c);

                if (node == null)
                    return false;

                tempNode = node;
            }

            if (tempNode.isLastChar()) {
                if (tempNode.getChild().isEmpty()) {
                    return false;
                }
            }

            return true;
        }

//        public void delete(String str){
//
//        }
    }
}