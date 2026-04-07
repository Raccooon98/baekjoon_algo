import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static Class[] classes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        classes = new Class[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            classes[i] = new Class(start, end);
        }

        Arrays.sort(classes, (o1, o2) -> {
            if (o1.st == o2.st) return o1.en - o2.en;
            return o1.st - o2.st;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(classes[0].en);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= classes[i].st) pq.poll();
            pq.offer(classes[i].en);
        }

        System.out.println(pq.size());
    }

    static class Class {
        int st, en;

        public Class(int st, int en) {
            this.st = st;
            this.en = en;
        }
    }
}
