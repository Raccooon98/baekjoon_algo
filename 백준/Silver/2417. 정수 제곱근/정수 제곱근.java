//N이 2^63까지임 썡으로 하면 시간제한 터짐
//이분탐색으로 시간을 줄여보자

import java.io.*;
import java.util.*;
public class Main{
    static long N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        long st =0, end = 4000000000L;
        long answer=0;

        while(st<=end){
            Long mid = st + (end - st) / 2;

            if (Math.pow(mid,2)>=N) {
                answer = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        System.out.println(answer);

    }
}
