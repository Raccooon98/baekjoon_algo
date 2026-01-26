//이걸 비트마스킹으로 어떻게 풀지

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int S = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("all")) {
                S = (1 << 21) - 1;
            } else if (command.equals("empty")) {
                S = 0;
            } else {
                int M = Integer.parseInt(st.nextToken());
                if (command.equals("add")) {
                    S |= 1 << M;
                } else if (command.equals("remove")) {
                    S &= ~(1 << M);
                } else if (command.equals("check")) {
                    sb.append((S & (1 << M)) != 0 ? 1 : 0).append("\n");
                } else if (command.equals("toggle")) {
                    S ^= 1 << M;
                }
            }
        }

        System.out.println(sb.toString());
    }
}
