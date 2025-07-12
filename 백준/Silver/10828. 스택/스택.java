
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> S = new Stack<>();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String order = br.readLine();
            if(order.startsWith("push")){
                int num = Integer.parseInt(order.split(" ")[1]);
                S.push(num);
            }else if (order.equals("pop")) {
                sb.append(S.isEmpty() ? -1 : S.pop()).append('\n');
            } else if (order.equals("size")) {
                sb.append(S.size()).append('\n');
            } else if (order.equals("empty")) {
                sb.append(S.isEmpty() ? 1 : 0).append('\n');
            } else if (order.equals("top")) {
                sb.append(S.isEmpty() ? -1 : S.peek()).append('\n');
            }

        }
        System.out.println(sb);
    }
}
