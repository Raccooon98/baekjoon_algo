//그냥 10칸짜리 배열 만들고 카운트 하기 , 비트마스킹 가능할듯
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int result = A*B*C;

        String str = String.valueOf(result);

        for(int i=0;i<str.length();i++){
            int a = str.charAt(i)-'0';
            arr[a]++;
        }

        for(int i=0;i<10;i++){
            bw.write(arr[i]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
