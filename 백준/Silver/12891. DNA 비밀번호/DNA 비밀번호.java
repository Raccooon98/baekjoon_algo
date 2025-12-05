import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[4];
    static int[] tmp = new int[4];
    static Map<Character, Integer> map = new HashMap<>();
    static String str;

    public static void main(String[] args) throws IOException {
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        str = br.readLine();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 0; i < P; i++) {
            add(i);
        }

        if (check()) ans++;

        for (int i = P; i < S; i++) {
            add(i);
            delete(i - P);

            if (check()) ans++;
        }

        System.out.println(ans);
    }

    static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (tmp[i] < arr[i]) {
                return false;
            }
        }

        return true;
    }

    static void add(int n) {
        char c = str.charAt(n);
        if (map.containsKey(c)) tmp[map.get(c)]++;
    }

    static void delete(int n) {
        char c = str.charAt(n);
        if (map.containsKey(c)) tmp[map.get(c)]--;
    }
}
