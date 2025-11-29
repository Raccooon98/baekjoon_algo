import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (String s : arr) {
            Map<Character, Integer> map = new HashMap<>();
            int len = s.length();
            if(len == 1){
                answer++;
                continue;
            }

            for (int i = 0; i < len; i++) {
                if(i==len-1){
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                }else{
                    if (s.charAt(i) == s.charAt(i + 1)) {
                        continue;
                    } else {
                        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                    }
                }

            }

            boolean check = true;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 1) {
                    check = false;
                }
            }

            if (check) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
