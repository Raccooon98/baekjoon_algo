import java.io.*;
import java.util.*;

public class Main {
    static String input, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        target = br.readLine();
        int targetLen = target.length();

        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            sb.append(c);

            if (sb.length() >= targetLen) {
                boolean check = true;

                for (int i = 0; i < targetLen; i++) {
                    if (sb.charAt(sb.length() - targetLen + i) != target.charAt(i)) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    sb.setLength(sb.length() - targetLen);
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
