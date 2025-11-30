import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int len = s.length();

        Stack<Character> stack = new Stack<>();
        boolean opened = false;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (!opened) {
                if (c == '<') {
                    if(stack.isEmpty()){
                        stack.push(c);
                    }else{
                        while(!stack.isEmpty()){
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                    opened = true;
                }else if(c == ' '){
                    if(stack.isEmpty()){
                        sb.append(' ');
                    }else{
                        while(!stack.isEmpty()){
                            sb.append(stack.pop());
                        }
                        sb.append(' ');
                        stack.clear();
                    }
                }else if(i==len-1){
                    stack.push(c);

                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }

                    sb.append(' ');
                    stack.clear();

                }else{
                    stack.push(c);
                    continue;
                }
            } else {
                if(c == '>'){
                    stack.push(c);
                    opened = false;
                    Stack<Character>tmp = new Stack<>();
                    while(!stack.isEmpty()){
                        tmp.push(stack.pop());
                    }
                    while(!tmp.isEmpty()){
                        sb.append(tmp.pop());
                    }
                    stack.clear();

                }else{
                    stack.push(c);
                    continue;
                }
            }

        }
        System.out.println(sb);
    }
}
