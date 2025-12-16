import java.io.*;
import java.util.*;

public class Main {
    static TrieNode root = new TrieNode();
    static Map<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TrieNode trie = new TrieNode();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            trie.insert(s);
        }

        System.out.println(sb.toString());
    }

    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int count;

        public void insert(String s) {
            TrieNode temp = root;
            boolean printed = false;
            StringBuilder tmp = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int idx = c - 'a';

                if (temp.child[idx] == null) {
                    temp.child[idx] = new TrieNode();
                }

                temp = temp.child[idx];
                temp.count++;
                tmp.append(c);

                if (!printed && temp.count == 1) {
                    sb.append(tmp.toString()).append("\n");
                    printed = true;
                }
            }

            if (!printed) {
                int cnt = map.getOrDefault(s, 0) + 1;
                map.put(s, cnt);
                if(cnt==1){
                    sb.append(s).append("\n");
                }else{
                    sb.append(s).append(cnt).append("\n");
                }
            } else {
                map.put(s, 1);
            }
        }
    }
}
