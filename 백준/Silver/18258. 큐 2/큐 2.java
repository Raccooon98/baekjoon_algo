import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            String order = br.readLine();
            if(order.startsWith("push")){
                q.add(Integer.parseInt(order.split(" ")[1]));
            }else if(order.startsWith("front")){
                if(q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(q.peek()).append('\n');
            }else if(order.startsWith("pop")) {
                if (!q.isEmpty())
                    sb.append(q.poll()).append("\n");
                else
                    sb.append("-1\n");
            }else if(order.startsWith("size")){
                sb.append(q.size()).append("\n");
            }else if(order.startsWith("empty")){
                if(q.isEmpty())
                    sb.append("1\n");
                else
                    sb.append("0\n");

            }else if(order.startsWith("back")){
                if(q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(((LinkedList<Integer>) q).peekLast()).append('\n');
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}
