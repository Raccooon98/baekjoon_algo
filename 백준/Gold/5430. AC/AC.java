import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            String order = br.readLine();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            Deque<Integer> q = new ArrayDeque<>();
            String input = br.readLine();
            if(N>0){
                String[] inputs = input.substring(1,input.length()-1).trim().split(",");
                for (String s : inputs) {
                    q.offer(Integer.parseInt(s));
                }
            }

            boolean isReverse = false;
            boolean isError = false;

            for (char c : order.toCharArray()) {
                if (c == 'R') {
                    isReverse = !isReverse;
                } else if (c == 'D') {
                    if (!q.isEmpty()) {
                        if (!isReverse) {
                            q.pollFirst();
                        } else {
                            q.pollLast();
                        }
                    } else{
                        isError=true;
                        break;
                    }
                }
            }

            if(isError){
                sb.append("error\n");
            }else{
                sb.append("[");

                if(!isReverse){
                    while (!q.isEmpty()) {
                        if (q.size() == 1) {
                            sb.append(q.poll());
                        } else {
                            sb.append(q.poll()).append(",");
                        }
                    }
                }else{
                    while (!q.isEmpty()) {
                        if (q.size() == 1) {
                            sb.append(q.pollLast());
                        } else {
                            sb.append(q.pollLast()).append(",");
                        }
                    }
                }
                sb.append("]").append("\n");
            }

        }

        System.out.println(sb);
    }
}
