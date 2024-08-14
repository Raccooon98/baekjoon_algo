import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		
		int [] dp =new int[N+1];
		
		//dp에 각각 큰 값 채워넣고 최솟값 구할 수 있게 만들기
		for(int i=1; i<=N;++i)
			dp[i]=N;
		
		for(int i=1;i<=N;++i) {
			for(int j=1;j*j<=i;++j) {
				dp[i] = Math.min(dp[i],dp[i-j*j]+1);
			}
		}
		System.out.println(dp[N]);
	}

}
