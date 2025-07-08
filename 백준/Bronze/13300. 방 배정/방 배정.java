//남자별 방, 여자별 방 에서 학년 별 방도 필요함
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N,K,S,Y;
    static int[][] gender= new int[2][7];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            gender[S][Y]++;
        }

        int count=0;
        for(int i=0;i<2;i++){
            for(int j=1;j<7;j++){
                if(gender[i][j]>K){
                    count+=gender[i][j]/K+1;
                } else if (gender[i][j]==0) {
                    continue;
                }
                else {
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }
}
