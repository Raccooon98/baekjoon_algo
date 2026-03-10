import java.util.*;
import java.io.*;

public class Main {
    static int N, M, size, min = Integer.MAX_VALUE;
    static int[][] board;
    static ArrayList<Camera> cctv;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0 && board[i][j] < 6) {
                    cctv.add(new Camera(i, j, board[i][j]));
                }
            }
        }

        size = cctv.size();
        DFS(board, 0);

        System.out.println(min);
    }

    static void DFS(int[][] arr, int depth) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
        }

        if (depth == size) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 0) count++;
                }
            }
            min = Math.min(min, count);
            return;
        } else {
            Camera cur = cctv.get(depth);

            int x = cur.x;
            int y = cur.y;

            if (cur.option == 1) {
                up(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }

                down(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }

                left(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }

                right(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }
            } else if (cur.option == 2) {
                up(tmp, x, y);
                down(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }

                left(tmp, x, y);
                right(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }
            } else if (cur.option == 3) {
                up(tmp, x, y);
                right(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }

                right(tmp, x, y);
                down(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }

                down(tmp, x, y);
                left(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }

                left(tmp, x, y);
                up(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }
            } else if (cur.option == 4) {
                up(tmp, x, y);
                right(tmp, x, y);
                down(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }

                right(tmp, x, y);
                down(tmp, x, y);
                left(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }

                down(tmp, x, y);
                left(tmp, x, y);
                up(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }

                left(tmp, x, y);
                up(tmp, x, y);
                right(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }
            } else if (cur.option == 5) {
                up(tmp, x, y);
                right(tmp, x, y);
                down(tmp, x, y);
                left(tmp, x, y);
                DFS(tmp, depth + 1);
                for (int i = 0; i < N; i++) {
                    tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
                }
            }
        }
    }

    static void up(int[][] tmp, int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (tmp[i][y] == 0) {
                tmp[i][y] = -1;
            } else if (tmp[i][y] == 6) {
                break;
            }
        }
    }

    static void down(int[][] tmp, int x, int y) {
        for (int i = x + 1; i < N; i++) {
            if (tmp[i][y] == 0) {
                tmp[i][y] = -1;
            } else if (tmp[i][y] == 6) {
                break;
            }
        }
    }

    static void left(int[][] tmp, int x, int y) {
        for (int j = y - 1; j >= 0; j--) {
            if (tmp[x][j] == 0) {
                tmp[x][j] = -1;
            } else if (tmp[x][j] == 6) {
                break;
            }
        }
    }

    static void right(int[][] tmp, int x, int y) {
        for (int j = y + 1; j < M; j++) {
            if (tmp[x][j] == 0) {
                tmp[x][j] = -1;
            } else if (tmp[x][j] == 6) {
                break;
            }
        }
    }

    static class Camera {
        int x, y, option;

        public Camera(int x, int y, int option) {
            this.x = x;
            this.y = y;
            this.option = option;
        }
    }
}
