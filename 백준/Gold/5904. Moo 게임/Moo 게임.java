import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();

        int len =3;
        int prev=3;
        int k=0;

        while(len<N){
            k++;
            prev=len;
            len=2*prev+(1+2+k);
        }

        Moo(len,k);


    }
    static void Moo(int len,int k){
        int prev = (len-(1+2+k))/2;
        if(k==0){
            if(N==1){
                System.out.println("m");
                return;
            }else{
                System.out.println("o");
                return;
            }
        }
        if(N<=prev){
            Moo(prev,k-1);
        }else if(prev+1<=N&&N<prev+(3+k)){
            if(prev+1==N){
                System.out.println("m");
            }else{
                System.out.println("o");
            }
        }else{
            N-=(prev+(3+k));
            Moo(prev,k-1);
        }
    }

}