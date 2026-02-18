import java.io.*;
import java.util.*;

public class Solution {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            String command = st.nextToken();

            board = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (command.equals("up")) {
                for (int j = 0; j < N; j++) {
                    Deque<Integer> q = new ArrayDeque<>();
                    boolean canMix = true;

                    for (int i = 0; i < N; i++) {
                        if (board[i][j] == 0) continue;

                        if (q.isEmpty()) {
                            q.addLast(board[i][j]);
                        } else {
                            if (canMix) {
                                if (q.peekLast() == board[i][j]) {
                                    q.addLast(q.pollLast() + board[i][j]);
                                    canMix = false;
                                } else {
                                    q.addLast(board[i][j]);
                                }
                            } else {
                                q.addLast(board[i][j]);
                                canMix = true;
                            }
                        }
                    }
                    for (int i = 0; i < N; i++) {
                        if (!q.isEmpty()) {
                            board[i][j] = q.pollFirst();
                        } else {
                            board[i][j] = 0;
                        }
                    }
                }
            } else if (command.equals("down")) {
                for (int j = 0; j < N; j++) {
                    Deque<Integer> q = new ArrayDeque<>();
                    boolean canMix = true;

                    for (int i = N - 1; i >= 0; i--) {
                        if (board[i][j] == 0) continue;

                        if (q.isEmpty()) {
                            q.addLast(board[i][j]);
                        } else {
                            if (canMix) {
                                if (q.peekLast() == board[i][j]) {
                                    q.addLast(q.pollLast() + board[i][j]);
                                    canMix = false;
                                } else {
                                    q.addLast(board[i][j]);
                                }
                            } else {
                                q.addLast(board[i][j]);
                                canMix = true;
                            }
                        }
                    }
                    for (int i = N - 1; i >= 0; i--) {
                        if (!q.isEmpty()) {
                            board[i][j] = q.pollFirst();
                        } else {
                            board[i][j] = 0;
                        }
                    }
                }
            } else if (command.equals("left")) {
                for (int i = 0; i < N; i++) {
                    Deque<Integer> q = new ArrayDeque<>();
                    boolean canMix = true;

                    for (int j = 0; j < N; j++) {
                        if (board[i][j] == 0) continue;

                        if (q.isEmpty()) {
                            q.addLast(board[i][j]);
                        } else {
                            if (canMix) {
                                if (q.peekLast() == board[i][j]) {
                                    q.addLast(q.pollLast() + board[i][j]);
                                    canMix = false;
                                } else {
                                    q.addLast(board[i][j]);
                                }
                            } else {
                                q.addLast(board[i][j]);
                                canMix = true;
                            }
                        }
                    }
                    for (int j = 0; j < N; j++) {
                        if (!q.isEmpty()) {
                            board[i][j] = q.pollFirst();
                        } else {
                            board[i][j] = 0;
                        }
                    }
                }
            } else if (command.equals("right")) {
                for (int i = 0; i < N; i++) {
                    Deque<Integer> q = new ArrayDeque<>();
                    boolean canMix = true;

                    for (int j = N - 1; j >= 0; j--) {
                        if (board[i][j] == 0) continue;

                        if (q.isEmpty()) {
                            q.addLast(board[i][j]);
                        } else {
                            if (canMix) {
                                if (q.peekLast() == board[i][j]) {
                                    q.addLast(q.pollLast() + board[i][j]);
                                    canMix = false;
                                } else {
                                    q.addLast(board[i][j]);
                                }
                            } else {
                                q.addLast(board[i][j]);
                                canMix = true;
                            }
                        }
                    }
                    for (int j = N - 1; j >= 0; j--) {
                        if (!q.isEmpty()) {
                            board[i][j] = q.pollFirst();
                        } else {
                            board[i][j] = 0;
                        }
                    }
                }
            }

            sb.append("#").append(t).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
