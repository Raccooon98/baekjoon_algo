import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int arr[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        double sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        //산술 평균
        sb.append(Math.round(sum / N)).append("\n");

        //중앙값
        int mid = arr[(N - 1) / 2];
        sb.append(mid).append("\n");

        //최빈값
        int count = 0;
        int max = -1;
        int mod = arr[0];
        boolean check = false;

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                count = 0;
            }

            if (max < count) {
                max = count;
                mod = arr[i];
                check = true;
            } else if (max == count && check == true) {
                mod = arr[i];
                check = false;
            }
        }
        sb.append(mod).append("\n");

        //끝-끝
        int diff = arr[N - 1] - arr[0];
        sb.append(diff).append("\n");

        System.out.println(sb);
    }
}
