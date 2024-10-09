import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.Scanner;
//N을 절반씩 줄여가면서 N/2의 제곱만큼 반복 수행 -> 4칸 조사 하면 


public class Main {
    private static int N;
    private static int[][] arr;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N=sc.nextInt();
        arr=new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                arr[i][j]=sc.nextInt();
            }
        }

        System.out.println(pulling(N,0,0));



    }

    static int pulling(int n,int x,int y) {
        if(n==2){
            int temp[] = new int[4];
            int idx=0;
            for(int i=x; i<x+2;i++){
                for(int j=y; j<y+2; j++){
                    temp[idx++]=arr[i][j];
                }
            }
            Arrays.sort(temp);
            return temp[2];
        }
        else{
            int temp[] = new int[4];
            n/=2;

            temp[0] = pulling(n,x,y);
            temp[1] = pulling(n,x+n,y+n);
            temp[2] = pulling(n,x,y+n);
            temp[3] = pulling(n,x+n,y);

            Arrays.sort(temp);
            return temp[2];

        }
    }
}
