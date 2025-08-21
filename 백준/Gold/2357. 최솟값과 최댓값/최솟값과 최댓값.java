//배열 복사해서 구간별로 정렬? - 너무 비효율
//top - down 으로 segment tree
import java.io.*;
import java.util.*;

public class Main {
    static int mintree[], maxtree[];
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxtree = new int[N * 4];
        mintree = new int[N * 4];

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        makeTree(0, N - 1, 1, arr, true);
        makeTree(0, N - 1, 1, arr, false);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findMin(0, N - 1, 1, a - 1, b - 1)).append(" ").append(findMax(0, N - 1, 1, a - 1, b - 1)).append("\n");
        }

        System.out.println(sb);
    }

    private static int makeTree(int start, int end, int index, int[] arr, boolean isMin) {
        if (start == end) {
            if (isMin) {
                mintree[index] = arr[start];
            } else {
                maxtree[index] = arr[start];
            }
            return arr[start];
        }

        int mid = (start + end) / 2;
        if (isMin) {
            mintree[index] = Math.min(makeTree(start, mid, index * 2, arr, isMin), makeTree(mid + 1, end, index * 2 + 1, arr, isMin));
        } else {
            maxtree[index] = Math.max(makeTree(start, mid, index * 2, arr, isMin), makeTree(mid + 1, end, index * 2 + 1, arr, isMin));
        }

        return isMin ? mintree[index] : maxtree[index];
    }

    private static int findMin(int start, int end, int index, int left, int right) {
        if (left > end || right < start) return 1000000001;
        if (left <= start && right >= end) return mintree[index];
        int mid = (start + end) / 2;
        return Math.min(findMin(start, mid, index * 2, left, right), findMin(mid + 1, end, index * 2 + 1, left, right));
    }

    private static int findMax(int start, int end, int index, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && right >= end) return maxtree[index];
        int mid = (start + end) / 2;
        return Math.max(findMax(start, mid, index * 2, left, right), findMax(mid + 1, end, index * 2 + 1, left, right));
    }
}
