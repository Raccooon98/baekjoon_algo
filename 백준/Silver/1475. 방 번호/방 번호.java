import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] count = new int[10];
    public static void main(String[] args) throws IOException {
        String num = br.readLine();

        for(int i=0; i<num.length();i++){
            int a = num.charAt(i)-'0';
            count[a]++;
        }
        // 6과 9는 바꿔쓸 수 있으므로 합쳐서 평균 처리
        int sixNine = (count[6] + count[9] + 1) / 2;
        count[6] = sixNine;
        count[9] = sixNine;

        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();
    }
}
