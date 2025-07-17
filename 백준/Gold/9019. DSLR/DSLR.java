//숫자가 별로 안커서 DSLR하는 경우를 다 넣어서 돌려도 될것 같음
//BFS 안되면 DFS? 다른 방법 시도해보기
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            Queue<Info> q =new LinkedList<>();
            boolean[] visited = new boolean[10000];

            q.offer(new Info(a,""));
            visited[a]=true;

            String result="";

            while(!q.isEmpty()){
                Info cur = q.poll();
                int num = cur.num;
                String cmd = cur.command;

                if(num ==b){
                    result = cmd;
                    break;
                }

                int D = (num*2)%10000;
                if(!visited[D]){
                    visited[D]=true;
                    q.offer(new Info(D,cmd+"D"));
                }

                int S = (num == 0)?9999:num-1;
                if(!visited[S]){
                    visited[S] = true;
                    q.offer(new Info(S,cmd+"S"));
                }

                //고민 많이 한 부분 (배열로 쪼개기 or 수학적으로 계산하기)
                //수학적으로 계산하기
                int L = (num%1000)*10+(num/1000);
                if(!visited[L]){
                    visited[L]=true;
                    q.offer(new Info(L,cmd+"L"));
                }

                int R = (num%10)*1000+(num/10);
                if(!visited[R]){
                    visited[R]=true;
                    q.offer(new Info(R,cmd+"R"));

                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Info{
        int num;
        String command;

        public Info(int num,String command){
            this.num = num;
            this.command=command;
        }
    }
}
