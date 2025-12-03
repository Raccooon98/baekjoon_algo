import java.io.*;
import java.util.*;

public class Main {
    static String input, bomb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        bomb = br.readLine();
        int blen = bomb.length();
        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            sb.append(c);

            if (sb.length() >= blen) {
                boolean match = true;
                for (int i = 0; i < blen; i++) {
                    if (sb.charAt(sb.length() - blen + i) != bomb.charAt(i)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    sb.setLength(sb.length() - blen);
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}
