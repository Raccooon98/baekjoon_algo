import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static PriorityQueue<Long> pq;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		pq=new PriorityQueue<>();
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		for(int i=0;i<N;++i) {
			long a=sc.nextInt();
			pq.add(a);
		}
		
		for(int i=0;i<M;++i) {
			long a=pq.poll();
			long b=pq.poll();
			
			pq.add(a+b);
			pq.add(a+b);
		}
		long res=0;
		while(!pq.isEmpty()) {
			res+=pq.poll();
		}
		System.out.println(res);
		
	}

}
