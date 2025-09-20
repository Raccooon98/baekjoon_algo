import java.io.*;
import java.util.*;

public class Main {
    static long S;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());

        long sum = 0;
        int cnt=0;
        for (int i = 1; i < 10000000; i++) {
            if(sum+i>S){
                continue;
            }else{
                sum+=i;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
