import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        int len = s.length();

        if (len == 1) {
            System.out.println(1);
            return;
        }
        if (len % 2 == 0) {
            for (int i = len / 2 - 1; i >= 0; i--) {
                left.push(s.charAt(i));
            }
            for (int i = len / 2; i <= len - 1; i++) {
                right.push(s.charAt(i));
            }
        } else {
            for (int i = len / 2 - 1; i >= 0; i--) {
                left.push(s.charAt(i));
            }
            for (int i = len / 2 + 1; i <= len - 1; i++) {
                right.push(s.charAt(i));
            }
        }

        while(!left.isEmpty()){
            if(left.pop() != right.pop()){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
