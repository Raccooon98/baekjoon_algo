import java.io.*;
import java.util.*;
public class Main {
    static int d, n, m;
    static int[] rocks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rocks = new int[n + 2];
        rocks[0] = 0;
        for (int i = 1; i <= n; i++) {
            rocks[i] = Integer.parseInt(br.readLine());
        }
        rocks[n + 1] = d;

        Arrays.sort(rocks);

        int low = 1;
        int high = d;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean check(int minDist) {
        int count = 0;
        int prev = 0;

        for (int i = 1; i < rocks.length; i++) {
            if (rocks[i] - prev < minDist) {
                count++;
            } else {
                prev = rocks[i];
            }
        }
        return count <= m;
    }
}