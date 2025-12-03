import java.io.*;
import java.util.*;

public class Main {
    static int len;
    static String s;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                set.add(s.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}
