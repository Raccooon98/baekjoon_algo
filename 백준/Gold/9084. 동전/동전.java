
//2^31-1보다 작으니까 굳이 long 필요 x
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int TC = Integer.parseInt(sc.nextLine());
		
		for(int T=1;T<=TC;++T) {
			int N = Integer.parseInt(sc.nextLine());
			int [] coins = new int[N];
			for(int i=0;i<N;++i) {
				coins[i] = sc.nextInt();
			}
			sc.nextLine();
			
			int M=Integer.parseInt(sc.nextLine());
			int[] dp = new int[M+1];
			//0원을 만드는 경우는 돈을 안내는 경우 한개뿐
			dp[0]=1;
			for(int i=0;i<N;++i) {
				for(int j=coins[i];j<=M;++j) {
					dp[j] = dp[j]+dp[j-coins[i]];
				}
			}
			System.out.println(dp[M]);
		}
		
	}
}