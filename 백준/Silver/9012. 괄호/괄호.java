import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr= new String[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            arr[i] = s;
        }

        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            char[] temp = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for(char c: temp){
                if(!stack.isEmpty()){
                    char tmp = stack.peek();
                    if(c == tmp){
                        stack.push(c);
                    }else{
                        stack.pop();
                    }
                }else{
                    if(c == ')'){
                        stack.push(c);
                        break;
                    }
                    stack.push(c);
                }
            }

            if(stack.isEmpty()){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
