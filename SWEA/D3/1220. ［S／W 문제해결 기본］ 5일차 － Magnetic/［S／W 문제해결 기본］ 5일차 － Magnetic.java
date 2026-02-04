import java.io.*;
import java.util.*;

public class Solution {
    static int[][] board;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            ans = 0;
            int N = Integer.parseInt(br.readLine());
            board = new int[100][100];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //왼쪽부터 1열씩 탐색하기
            for (int j = 0; j < 100; j++) {
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < 100; i++) {
                    int num = board[i][j];

                    if (num == 1) {
                        stack.clear();
                        stack.push(num);
                    } else if (num == 2) {
                        if (!stack.isEmpty() && stack.peek() == 1) {
                            ans++;
                            stack.clear();
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }
}
