import java.io.*;
import java.util.*;

public class Main {
    static String input, target;
    static int inputLen, targetLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        target = br.readLine();
        inputLen = input.length();
        targetLen = target.length();

        int left = 0;
        int right = left + targetLen-1;
        int count = 0;

        while (right <= inputLen - 1) {
            if (check(left, right)) {
                left = right + 1;
                right = left + targetLen-1;
                count++;
            } else {
                left++;
                right++;
            }
        }

        System.out.println(count);
    }

    static boolean check(int st, int en) {
        int count = 0;
        for (int i = st; i <= en; i++) {
            if (input.charAt(i) != target.charAt(count)) {
                return false;
            }
            count++;
        }

        return true;
    }
}
