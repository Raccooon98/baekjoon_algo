import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] input;
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        input = new String[N];
        int[] alphabet = new int[26]; // 각 알파벳의 가중치

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
            int power = (int) Math.pow(10, input[i].length() - 1);

            for (int j = 0; j < input[i].length(); j++) {
                // 각 문자의 자릿수 가중치를 누적
                alphabet[input[i].charAt(j) - 'A'] += power;
                power /= 10;
            }
        }

        Arrays.sort(alphabet);

        int sum = 0;
        int num = 9;

        for (int i = 25; i >= 0; i--) {
            if (alphabet[i] == 0) break;
            sum += alphabet[i] * num;
            num--;
        }

        System.out.println(sum);
    }
}
