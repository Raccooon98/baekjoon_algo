//회전연산을 하기에 Deque가 유리하다고 생각되어 시도해보기
//회전 연산은 쉬운데 인덱스 접근이 안되어서 그냥 ArrayList로 구현......
import java.io.*;
import java.util.*;

public class Main {
    static int N, K, broken_belt;
    static ArrayList<Integer> belt = new ArrayList<>(); //벨트 내구도 저장하는 덱
    static ArrayList<Boolean> robot = new ArrayList<>(); //초기에 2N개 만큼 false로채워놓고 left에만 로봇 넣어주는식으로 구현

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= 2 * N; i++) {
            belt.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            robot.add(false);
        }

        broken_belt = 0;
        int step = 0;

        while (broken_belt < K) {
            step++;

            rotate_belt();

            move_robot();

            if (belt.get(0) > 0) {
                robot.set(0, true);
                belt.set(0, belt.get(0) - 1);
                if (belt.get(0) == 0)
                    broken_belt++;
            }
        }

        System.out.println(step);

    }

    private static void rotate_belt() {
        belt.add(0, belt.remove(N * 2 - 1));
        robot.add(0, robot.remove(N - 1));

        if (robot.get(N - 1)) {//N-1에 도착하면 로봇 내리기
            robot.set(N - 1, false);
        }
    }

    private static void move_robot() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot.get(i) && !robot.get(i + 1) && belt.get(i + 1) > 0) {
                robot.set(i, false);
                robot.set(i + 1, true);
                belt.set(i + 1, belt.get(i + 1) - 1);
                if (belt.get(i + 1) == 0)
                    broken_belt++;
            }
        }

        if (robot.get(N - 1)) {//N-1에 도착하면 로봇 내리기
            robot.set(N - 1, false);
        }
    }
}
