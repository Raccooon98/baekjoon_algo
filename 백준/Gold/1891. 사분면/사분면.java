//종이의 크기는 2^d 가 될텐데... d가 50까지 니까 long으로...
import java.io.*;
import java.util.*;

public class Main {
    static int d;
    static String input;
    static long X, Y;
    static long cx, cy;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        input = st.nextToken();
        long size = 1L << d;

        st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken()); //상하 연산을 반대로 하기
        Y = Long.parseLong(st.nextToken()); //좌우 그대로 더하기


        find(0, 0, 0, size);
        cx -= Y;
        cy += X;

        if (cx >= 0 && cy >= 0 && cx < size && cy < size) {
            check(size, 0, 0);
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    private static void find(int idx, long x, long y, long size) {
        if (idx == d) {
            cx = x;
            cy = y;
            return;
        }

        long half = size / 2;
        int num = input.charAt(idx) - '0';

        if (num == 1)//1사분면
            find(idx + 1, x , y+half, half);
        else if (num == 2)//2사분면
            find(idx + 1, x, y, half);
        else if (num == 3)//3사분면
            find(idx + 1, x + half, y, half);
        else if (num == 4)//4사분면
            find(idx + 1, x+ half, y+ half, half);
    }

    private static void check(long size, long x, long y) {
        if (size == 1) {
            return;
        }

        long midSize = size / 2;

        if (cx < x + midSize && cy >= y + midSize) { // 1사분면
            sb.append(1);
            check(midSize, x, y + midSize);
        } else if (cx < x + midSize && cy < y + midSize) { // 2사분면
            sb.append(2);
            check(midSize, x, y);
        } else if (cx >= x + midSize && cy < y + midSize) { // 3사분면
            sb.append(3);
            check(midSize, x + midSize, y);
        } else if (cx >= x + midSize && cy >= y + midSize) { // 4사분면
            sb.append(4);
            check(midSize, x + midSize, y + midSize);
        }
    }
}
