import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int maxweight = sc.nextInt();
		sc.nextLine();
		int[] dp = new int[maxweight+1];
		item[] items = new item[N+1]; 
		
		for(int i=1;i<=N;++i) {
			int a,b;
			a=sc.nextInt();
			b=sc.nextInt();
			sc.nextLine();
			
			items[i] = new item(a,b);
		}
		
		for(int i=1;i<=N;++i) {
			for(int j=maxweight;j>=items[i].weight;j--) {
				dp[j] = Math.max(dp[j], dp[j-items[i].weight]+items[i].value);
			}
		}
		System.out.println(dp[maxweight]);
	}
	
	
	//item 정보 담을 클래스(구죠체같은 느김)
	public static class item{
		int weight;
		int value;
		
		item(int weight,int value){
			this.weight = weight;
			this.value = value;
		}
	}

}
