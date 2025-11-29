import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        Set<String> set = new HashSet<>();
        N = Integer.parseInt(br.readLine());
        arr = new String[N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            set.add(s);
        }

        arr = set.toArray(new String[0]);
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2); // 사전순 정렬 추가
            }
            return o1.length() - o2.length();
        });

        for(String s:arr){
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());
    }
}
