//게임이 종료되는 턴의 번호를 출력한다. 그 값이 1,000보다 크거나 절대로 게임이 종료되지 않는 경우에는 -1을 출력한다.

#include<iostream>
#include<vector>
#include<cstring>
#include<queue>
using namespace std;

int N, K;
struct Chess {
	int x, y, dir;
};
int Map[13][13];
vector<int> chessMap[14][14];
Chess chess[11];

int dx[]{ 0,0,0,-1,1 };
int dy[]{ 0,1,-1,0,0 };

int reversedir(int dir) {
	if (dir == 1) return 2;
	else if (dir == 2) return 1;
	else if (dir == 3) return 4;
	else if (dir == 4) return 3;
}

void Move(int x,int y,int dir,int pos, int state) {
	int nx = x + dx[dir];
	int ny = y + dy[dir];

	if (state == 0) {//흰 블록 -> 여기도 마찬가지로 자신이 중간에 껴있을 수도 있기때문에 자신이 몇번째에 있는지 인덱스 확인 필요함


		//for (auto& v : chessMap[x][y]) {
		//	chessMap[nx][ny].push_back(v);
		//}
		int count = 0;
		for (auto i = pos; i < chessMap[x][y].size(); ++i) {
			chessMap[nx][ny].push_back(chessMap[x][y][i]);
			chess[chessMap[x][y][i]].x = nx;
			chess[chessMap[x][y][i]].y = ny;
			count += 1;
		}
		for (auto i = 0; i < count; ++i)
			chessMap[x][y].pop_back();
	}
	else if (state == 1) {//빨간블록 -> 전체를 뒤집는다 생각했는데 자신보다 위에 있는 말까지만 뒤집는거임 그러므로 자기자신이 몇번째 인덱스인지 확인 필요
		int count = 0;
		for(int i = chessMap[x][y].size()-1; i >= pos; --i) {//뒤집어주기
			chessMap[nx][ny].push_back(chessMap[x][y][i]);
			chess[chessMap[x][y][i]].x = nx;
			chess[chessMap[x][y][i]].y = ny;
			count += 1;
		}
		for (auto i = 0; i < count; ++i)
			chessMap[x][y].pop_back();
	}
	else if (state == 2) {//파란블록, 벽으로 나갔을때
		int Dir = reversedir(dir);
		chess[chessMap[x][y][pos]].dir = Dir;

		int nnx = x + dx[Dir];
		int nny = y + dy[Dir];
		//방향은 우선 바꿔주고
		//움직일수 있는 조건에서만 한번 움직여주기

		if (nnx >= 0 && nnx < N && nny >= 0 && nny < N) {//continue가 안되니까 만족할때로
			if (Map[nnx][nny] != 2)
				Move(x, y, Dir, pos, Map[nnx][nny]);
		}
	}
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	int time = 0,pos=0;
	bool check = false;

	cin >> N >> K;

	for (auto i = 0; i < N; ++i) {
		for (auto j = 0; j < N; ++j) {
			cin >> Map[i][j];
		}
	}

	//다음 K개의 줄에 말의 정보가 1번 말부터 순서대로 주어진다. 확인
	for (auto k = 0; k < K; ++k) {
		int a, b, c;
		cin >> a >> b >> c;
		chess[k] = { a - 1,b - 1,c };
		chessMap[a - 1][b - 1].push_back(k);
	}

	while (1) {
		if (time > 1000) break;
		for (auto k = 0; k < K; ++k) {
			auto& [x, y, dir] = chess[k];
			for (int d = 0; d < chessMap[x][y].size(); ++d) {
				if (chessMap[x][y][d] == k)pos = d;
			}

			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {//벗어나면 안움직이는게 아닌 파란칸과 동일하게 방향 반대로 바꿔주기
				Move(x, y, dir,pos, 2);
			}
			else {
				Move(x, y, dir,pos, Map[nx][ny]);
			}


			for (auto idx = 0; idx < K; ++idx) {
				int r = chess[idx].x;
				int c = chess[idx].y;
				if (chessMap[r][c].size() >= 4) {
					check = true;
					break;
				}
 			}
			
		}

		if (check == true)
			break;
		time++;
	}

	if (check == true)
		cout << time + 1 << '\n';
	else
		cout << -1 << '\n';

	return 0;
}