import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int ans=Integer.MAX_VALUE;
    static boolean s[]; //불가능한 숫자 배열
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        s=new boolean[1002];

        st =new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            s[Integer.parseInt(st.nextToken())]=true;
        }

        for(int i=1;i<=1000;i++){
            for(int j=i;j<=1000;j++){
                for(int k=j;k<=1001;k++){
                    if(s[i]||s[j]||s[k])
                        continue;

                    ans = Math.min(ans,Math.abs(N-i*j*k));
                }
            }
        }

        System.out.println(ans);
    }
}
