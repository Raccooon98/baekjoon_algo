import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int count = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            String s = br.readLine();

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                count++;
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);
    }
}
