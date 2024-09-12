import java.util.Scanner;

//
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int R=sc.nextInt();
		int C=sc.nextInt();
		sc.nextLine();
		
		int[][] A=new int[R][C];
		int[][] B=new int[R][C];
	
		for(int r=0;r<R;++r) {
			String input=sc.nextLine();
			for(int c=0;c<C;++c) {
				A[r][c]=input.charAt(c)-'0';
			}
		}
		
		for(int r=0;r<R;++r) {
			String input=sc.nextLine();
			for(int c=0;c<C;++c) {
				B[r][c]=input.charAt(c)-'0';
			}
		}
		int cnt=0;
		for(int r=0;r<R;++r) {
			for(int c=0;c<C;++c) {
				if(A[r][c]!=B[r][c]&&r+2<R&&c+2<C) {
					for(int i=r;i<r+3;i++) {
						for(int j=c;j<c+3;++j) {
							if(A[i][j]==0)
								A[i][j]=1;
							else
								A[i][j]=0;
						}
					}
					cnt++;
				}
			}
		}
		
		for(int r=0;r<R;++r) {
			for(int c=0;c<C;++c) {
				if(A[r][c]!=B[r][c]) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(cnt);
		
		
	}

}
