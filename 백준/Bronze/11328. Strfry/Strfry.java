//카운트 두개 비교해서 차이를 다 더했을때 0이어야 strfry가능
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    public static void main(String[] args)throws IOException{
        N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;++i){
            int[][]count = new int[2][26];
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            for(char a:str1.toCharArray()){
                count[0][a-'a']++;
            }
            for(char b:str2.toCharArray()){
                count[1][b-'a']++;
            }
            int sum=0;
            for(int j=0;j<26;++j){
                sum+=Math.abs(count[0][j]-count[1][j]);
            }
            if(sum==0)
                System.out.println("Possible");
            else
                System.out.println("Impossible");
        }
    }
}
