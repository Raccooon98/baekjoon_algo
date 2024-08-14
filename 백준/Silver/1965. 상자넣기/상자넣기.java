

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int [] arr =new int[N];
		int [] dp = new int[N];
		
		for(int i=0;i<N;++i) {
			arr[i]=sc.nextInt();
		}
		sc.nextLine();
		int result=-1;
		for(int i=0;i<N;++i) {
			dp[i]=1;
			
			for(int j=0;j<N;++j) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
	}

}
