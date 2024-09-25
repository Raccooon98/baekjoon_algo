import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static List<Integer>[] list;
    static int N,M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();

        int[] indegree=  new int[N+1];

        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            list[i] =new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            int a=sc.nextInt(),b=sc.nextInt();
            list[a].add(b);
            indegree[b]++;

        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<=N; i++) {
            if(indegree[i]==0)
                pq.add(i);
        }

        List<Integer> res=new ArrayList<>();

        while(!pq.isEmpty()){
            int cur =pq.poll();
            res.add(cur);
            for(int next:list[cur]){
                indegree[next]--;

                if(indegree[next]==0){
                    pq.add(next);
                }
            }
        }

        for(int a:res){
            System.out.print(a+" ");
        }
    }
}
