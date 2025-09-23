import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int n = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            for (; n <= num; n++) {
                stack.push(n);
                sb.append("+").append("\n");
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}
