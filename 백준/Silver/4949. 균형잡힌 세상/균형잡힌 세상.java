import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("."))
                break;
            else {
                String tmp = check(s);
                sb.append(tmp).append("\n");
            }
        }

        System.out.println(sb);
    }

    static String check(String s){
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                }else {
                    stack.pop();
                }
            }else if(c == ']'){
                if(stack.isEmpty() || stack.peek()!='['){
                    return "no";
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return "yes";
        }else {
            return "no";
        }
    }
}
