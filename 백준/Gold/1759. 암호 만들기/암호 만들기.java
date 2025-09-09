import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new char[C];

        for(int i=0;i<C;i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        DFS(0, "", 0, 0);
        System.out.println(sb);
    }

    private static void DFS(int idx, String password, int acount, int bcount) {
        if (password.length() == L) {
            if (acount >= 1 && bcount >= 2) {
                sb.append(password).append("\n");
            }
            return;
        }

        if (idx >= C)
            return;

        char cur = arr[idx];
        if(isVowel(cur)){
            DFS(idx+1,password+cur,acount+1,bcount);
        }else{
            DFS(idx+1,password+cur,acount,bcount+1);
        }

        DFS(idx+1,password,acount,bcount);

    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
