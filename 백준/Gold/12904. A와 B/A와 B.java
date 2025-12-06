import java.io.*;
import java.util.*;

public class Main {
    static String S, T;
    static int slen, tlen;
    static int[] s = new int[2];
    static int[] t = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        S = br.readLine();
        T = br.readLine();
        sb.append(T);

        slen = S.length();
        tlen = T.length();

        //T -> S로 만들기
        for (int i = tlen - 1; i >= slen; i--) {
            char c = sb.charAt(i);
            if (c == 'A') {
                sb.deleteCharAt(i);
            } else if (c == 'B') {
                sb.deleteCharAt(i).reverse();
            }
        }

        if(sb.toString().equals(S))
            System.out.println(1);
        else{
            System.out.println(0);
        }
    }
}
