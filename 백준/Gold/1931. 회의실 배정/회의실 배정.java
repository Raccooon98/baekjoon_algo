import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Info[] arr = new Info[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Info(start, end);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int ans = 0;
        int t = 0;

        for (int i = 0; i < N; i++) {
            if (t > arr[i].start) continue;
            ans++;
            t = arr[i].end;
        }

        System.out.println(ans);
    }

    static class Info {
        int start;
        int end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
