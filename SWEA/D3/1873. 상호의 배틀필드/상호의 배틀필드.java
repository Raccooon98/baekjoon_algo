
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[]directoions = {'^','v','<','>'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); // 게임 맵의 높이
            int W = Integer.parseInt(st.nextToken()); // 게임 맵의 너비
            
            // 맵 입력 받기
//            String[][] map = new String[H][W];
            char[][] map = new char[H][W];
            int car_x = -1, car_y = -1, dir = -1;
            for(int i = 0; i < H; i++) {
//                st = new StringTokenizer(br.readLine());
                char[] input = br.readLine().toCharArray();
                for(int j = 0; j < W; j++) {
                    map[i][j] = input[j];
                    
                    // 초기 전차의 위치와 방향 탐색
                    switch(map[i][j]) {
                    case '^':
                        car_x = i;
                        car_y = j;
                        dir = 0;
                        break;
                    case 'v':
                        car_x = i;
                        car_y = j;
                        dir = 1;
                        break;
                    case '<':
                        car_x = i;
                        car_y = j;
                        dir = 2;
                        break;
                    case '>':
                        car_x = i;
                        car_y = j;
                        dir = 3;
                        break;
                    }
                }
            }
            
            int N = Integer.parseInt(br.readLine()); // 입력의 개수
            String str = br.readLine(); // 사용자의 입력들
            
            for(int i = 0; i < str.length(); i++) {
                
                int nx, ny;
                char order=str.charAt(i);
                
                if(order=='S') {
                	nx = car_x;
                    ny = car_y;
                    
                    // 다음 위치가 맵 범위를 벗어나면 패스
                    
                    
                    while(true) {
                    	nx += dx[dir];
                        ny += dy[dir];
                        if(nx < 0 || nx >= H || ny < 0 || ny >= W) {
                            break;
                        }
                    	if(map[nx][ny] == '#') { // 포탄이 강철 벽을 만나면
                            break; // 포탄 소멸 (아무 일도 일어나지 않음)
                        }
                        else if(map[nx][ny] == '*') { // 포탄이 벽돌 벽을 만나면
                            map[nx][ny] = '.'; // 벽이 파괴되어 평지로 바뀐 후
                            break; // 포탄 소멸
                        }
                    }
                    
                }
                else {
                	switch(order) {
                    case 'U': // 윗칸이 평지이면 위로 이동
                        dir = 0; // 전차의 방향을 위쪽으로 변경후
                        
                        break;
                        
                    case 'D': // 아랫칸이 평지이면 아래로 이동
                        dir = 1; // 전차의 방향을 아래쪽으로 변경
                        
                        break;
                        
                    case 'L': // 왼쪽이 평지이면 왼쪽으로 이동
                        dir=2;
                        break;
                        
                    case 'R': // 오른쪽이 평지이면 오른쪽으로 이동
                        dir=3;
                        break;
                    }
                    map[car_x][car_y] = directoions[dir];
                    
                    nx = car_x + dx[dir];
                    ny = car_y + dy[dir];
                    
                    // 다음 위치가 맵 범위를 벗어나면 패스
                    if(nx < 0 || nx >= H || ny < 0 || ny >= W) {
                        continue;
                    }
                    
                    if(map[nx][ny] == '.') { // 평지이면 이동
                        map[nx][ny] = directoions[dir];
                        map[car_x][car_y] = '.';
                        
                        car_x = nx;
                        car_y = ny;
                    }
                    
                }
            }
            
            System.out.print("#" + test_case + " ");
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}