import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int K=sc.nextInt();
		int X=sc.nextInt();
		
		int[] dist = new int[N+1];
		
		List<Integer>[] adj=new List[N+1];
		
		for(int i=0;i<=N;++i) {
			adj[i]=new ArrayList<>();
		}
		
		for(int i=1;i<=M;++i) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			adj[a].add(b);
		}
		
		Arrays.fill(dist, -1);
		Queue<Integer> q =new LinkedList<>();
		q.add(X);
		dist[X]=0;
		List<Integer> answers=new ArrayList<>();
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next:adj[cur]) {
				if(dist[next]!=-1)
					continue;
				dist[next] = dist[cur]+1;
				q.add(next);
				
				if(dist[next]==K) {
					answers.add(next);
				}
			}
		}
		answers.sort(null);
		
		if(answers.size()==0)
			System.out.println(-1);
		else
			for(int a:answers) {
				System.out.println(a);
			}
		
	}

}
