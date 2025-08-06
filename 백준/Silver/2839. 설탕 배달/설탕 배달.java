import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans =-1;

        for (int i = N / 5; i >= 0; i--) {
            int extra = N - (i * 5);
            if (extra % 3 == 0) {
                ans = i + (extra / 3);
                break;
            }
        }
        System.out.println(ans);
    }
}
