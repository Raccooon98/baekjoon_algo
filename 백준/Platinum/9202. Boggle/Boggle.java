import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static Trie trie;
    static Map<Integer, Integer> score = new HashMap<>();
    static Map<String, Integer> words;
    static int result, maxlen, count;
    static String longest;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int w = Integer.parseInt(br.readLine());
        score.put(1, 0);
        score.put(2, 0);
        score.put(3, 1);
        score.put(4, 1);
        score.put(5, 2);
        score.put(6, 3);
        score.put(7, 5);
        score.put(8, 11);
        trie = new Trie();
        String[] arr = new String[w];
        for (int i = 0; i < w; i++) {
            String s = br.readLine();
            arr[i] = s;
            trie.insert(s);
        }
        br.readLine();

        int b = Integer.parseInt(br.readLine());
        for (int B = 0; B < b; B++) {
            result = 0;
            maxlen = 0;
            count = 0;
            board = new char[4][4];
            words = new HashMap<>();
            for (String s : arr) {
                words.put(s, 0);
            }

            for (int i = 0; i < 4; i++) {
                board[i] = br.readLine().toCharArray();
            }
            br.readLine();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    vis = new boolean[4][4];
                    vis[i][j] = true;
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(board[i][j]);
                    DFS(i, j, buffer);
                }
            }
            sb.append(result)
                    .append(" ")
                    .append(longest)
                    .append(" ")
                    .append(count)
                    .append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void DFS(int x, int y, StringBuffer buffer) {
        String s = buffer.toString();
        if (!trie.check(s)) {
            return;
        } else {
            if (trie.search(s) && words.get(s) == 0) {
                result += score.get(s.length());
                words.put(s, 1);
                count++;
                if (s.length() > maxlen ||
                        (s.length() == maxlen && s.compareTo(longest) < 0)) {
                    maxlen = s.length();
                    longest = s;
                }
            }
        }

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
            if (vis[nx][ny]) continue;

            vis[nx][ny] = true;
            DFS(nx, ny, buffer.append(board[nx][ny]));
            buffer.deleteCharAt(buffer.length() - 1);
            vis[nx][ny] = false;
        }
    }

    private static class Node {
        Map<Character, Node> child = new HashMap<>();
        boolean isLastWord;

        public Node() {
            child = new HashMap<>();
            isLastWord = false;
        }
    }

    private static class Trie {
        Node root = new Node();

        public void insert(String str) {

            Node tempNode = root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                tempNode = tempNode.child.computeIfAbsent(c, k -> new Node());
            }

            tempNode.isLastWord = true;
        }

        public boolean search(String str) {

            Node tempNode = root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                Node node = tempNode.child.get(c);

                if (node == null) {
                    return false;
                }

                tempNode = node;
            }

            if (!tempNode.isLastWord)
                return false;

            return true;
        }

        public boolean check(String str) {
            Node tempNode = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                Node node = tempNode.child.get(c);

                if (node == null) {
                    return false;
                }

                tempNode = node;
            }

            return true;
        }
    }
}
