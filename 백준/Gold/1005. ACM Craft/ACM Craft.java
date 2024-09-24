import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt(); // Test case number
        for (int T = 1; T <= TC; T++) {
            N = sc.nextInt(); // Number of buildings
            K = sc.nextInt(); // Number of rules
            int[] values = new int[N + 1]; // Time to build each building
            int[] cnt = new int[N + 1]; // In-degree count
            int[] time = new int[N + 1]; // Minimum time to build each building

            ArrayList<Integer>[] list = new ArrayList[N + 1];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 1; i <= N; i++) {
                values[i] = sc.nextInt();
            }

            for (int i = 0; i < K; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                list[a].add(b);
                cnt[b]++;
            }

            int goal = sc.nextInt();

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (cnt[i] == 0) {
                    q.add(i);
                    time[i] = values[i]; // 초기 건설 시간은 자기 자신의 시간
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next : list[cur]) {
                    cnt[next]--;
                    // 다음 건물은 현재 건물까지 걸린 시간 + 자기 건설 시간을 더한 값 중 최대를 취함
                    time[next] = Math.max(time[next], time[cur] + values[next]);

                    if (cnt[next] == 0) {
                        q.add(next);
                    }
                }
            }

            // 목표 건물까지 걸린 시간 출력
            System.out.println(time[goal]);
        }
    }
}