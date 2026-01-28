import java.io.*;
import java.util.*;

public class Main {
    static int S, P;
    static int[] tmp = new int[4];
    static int[] count = new int[4];
    static Map<Character, Integer> map = new HashMap<>();
    static String input;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int ans = 0;
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        input = br.readLine();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }

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

    static void add(int num) {
        char c = input.charAt(num);
        if (map.containsKey(c)) tmp[map.get(c)]++;
    }

    static void delete(int num) {
        char c = input.charAt(num);
        if (map.containsKey(c)) tmp[map.get(c)]--;
    }

    static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (tmp[i] < count[i]) {
                return false;
            }
        }
        return true;
    }
}
