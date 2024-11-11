import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Info {
    int no, dir;

    public Info(int no, int dir) {
        this.no = no;
        this.dir = dir;
    }
}

public class Main {
    static String[] gear = new String[5];
    static int[] spinhow = new int[5];
    static boolean[] check = new boolean[4];
    static int K;
    static Info[] order = new Info[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니바퀴 입력
        for (int i = 1; i <= 4; i++) {
            gear[i] = br.readLine();
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            order[i] = new Info(a, b);
        }

        for (int i = 0; i < K; i++) {
            canspin(); // 현재 톱니 상태 확인
            int no = order[i].no;
            int curdir = order[i].dir;

            make_dir(no, curdir); // 각 톱니의 회전 방향 결정

            // 각 톱니를 회전
            for (int j = 1; j <= 4; j++) {
                if (spinhow[j] != 0) {
                    spingear(j, spinhow[j]);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i + 1].charAt(0) == '1') {
                sum += Math.pow(2, i);
            }
        }

        System.out.println(sum);
    }

    public static void canspin() {
        for (int i = 1; i <= 3; i++) {
            check[i] = gear[i].charAt(2) != gear[i + 1].charAt(6);
        }
    }

    public static void make_dir(int no, int dir) {
        // 모든 톱니의 회전 방향을 0으로 초기화
        for (int i = 0; i < 5; i++) {
            spinhow[i] = 0;
        }
        spinhow[no] = dir;

        // 왼쪽 톱니들 회전 방향 설정
        for (int i = no - 1; i >= 1; i--) {
            if (check[i]) {
                spinhow[i] = -spinhow[i + 1];
            } else {
                break;
            }
        }

        // 오른쪽 톱니들 회전 방향 설정
        for (int i = no + 1; i <= 4; i++) {
            if (check[i - 1]) {
                spinhow[i] = -spinhow[i - 1];
            } else {
                break;
            }
        }
    }

    public static void spingear(int no, int dir) {
        char[] temp = gear[no].toCharArray();
        char[] rotated = new char[8];

        for (int i = 0; i < 8; i++) {
            rotated[i] = temp[(i + 8 - dir) % 8];
        }
        gear[no] = new String(rotated);
    }
}
