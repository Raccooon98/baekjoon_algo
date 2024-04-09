#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

int result = 0;
int shark_x = 0, shark_y = 0;//상어 초기위치
struct Info {
	int num;
	int x, y;
	int dir;
	bool isAlive;
};

Info Fish[17];


int Map[4][4];

int dx[]{-1,-1,0,1,1,1,0,-1};
int dy[]{0,-1,-1,-1,0,1,1,1};

void DFS(int Map[][4], Info *Fish, int sx, int sy, int sum) {
	//배열과 물고기를 복사해서 사용
	int tmp_Map[4][4];
	Info tmp_Fish[17];

	for (int i = 0; i < 4; ++i)
		for (int j = 0; j < 4; ++j)
			tmp_Map[i][j] = Map[i][j];

	for (int i = 0; i <= 16; ++i)
		tmp_Fish[i] = Fish[i];

	int s = tmp_Map[sx][sy]; //상어가 먹은 숫자
	tmp_Map[sx][sy] = 0;//맵에서 빼주기
	int sd = tmp_Fish[s].dir;
	tmp_Fish[s].isAlive = false;

	sum += tmp_Fish[s].num;
	result = max(result, sum);

	for (auto& [fnum, fx, fy, fdir, flive] : tmp_Fish) {
		if (flive == false) continue;//죽었으면 건너뛰기
		int nx = fx + dx[fdir];
		int ny = fy + dy[fdir];

		while (1) {
			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)fdir = (fdir + 1) % 8;
			else if (nx == sx && ny == sy)fdir = (fdir + 1) % 8;
			else break;
			nx = fx + dx[fdir]; ny = fy + dy[fdir];
		}

		if (tmp_Map[nx][ny]) {
			int tmp = tmp_Map[nx][ny];
			tmp_Map[fx][fy] = tmp;
			tmp_Fish[tmp].x = fx;
			tmp_Fish[tmp].y = fy;
			fx = nx; fy = ny;
			tmp_Map[nx][ny] = fnum;
		}
		else {
			tmp_Map[fx][fy] = 0;
			fx = nx; fy = ny;
			tmp_Map[nx][ny] = fnum;
		}
	}
	//상어 이동 근데 3칸까지니까
	for (int i = 1; i <= 3; ++i) {
		int nx = sx + dx[sd] * i;
		int ny = sy + dy[sd] * i;

		if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)
			break;
		if (tmp_Map[nx][ny])
			DFS(tmp_Map,tmp_Fish,nx,ny,sum);
	}
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	Fish[0].isAlive = false;//1~16번 이기때문에 0번 죽이기
	for (int i = 0; i < 4; ++i) {
		for (int j = 0; j < 4; ++j) {
			int n,d; 
			cin >> n >> d;
			Map[i][j] = n;
			auto& [num, x, y, dir, isAlive] = Fish[n];
			num = n;
			x = i, y = j;
			dir = d - 1;
			isAlive = true;
		}
	}
	DFS(Map,Fish,0,0,0);

	cout << result<<'\n';

	return 0;
}