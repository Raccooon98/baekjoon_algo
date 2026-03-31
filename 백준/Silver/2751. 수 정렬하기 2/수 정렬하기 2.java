import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            arr.add(n);
        }

        Collections.sort(arr);

        for (int n : arr) {
            sb.append(n).append("\n");
        }

        System.out.println(sb.toString());
    }
}
