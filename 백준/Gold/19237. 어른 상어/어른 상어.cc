#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>
using namespace std;

struct smell_info {
	int id;
	int smell;//몇초뒤에 사라지는지
};

int dx[]{0,-1,1,0,0}; //1, 2, 3, 4는 각각 위, 아래, 왼쪽, 오른쪽을 의미한다.
int dy[]{0,0,0,-1,1};

//vector<int> Map[21][21];
int Map[21][21];
smell_info smell[21][21];

struct Shark {
	int x,y;
	int dir;
	int priority[5][4];
	bool isAlive;
};

Shark shark[401];

int N, M, K, result;

void Move() {//디버깅할때 빨리 넘기기위해 분리
	int num = 0;
	for (auto& [x, y, dir, prty, isAlive] : shark) {
		if (!isAlive) {
			num++;
			continue;
		}
		if (num > M)break; //상어가 400마리 까지 가능해서 시간 줄이기

		bool cango = false;

		for (int i = 0; i < 4; ++i) {
			int cdir = shark[num].priority[dir][i];
			int nx = x + dx[cdir], ny = y + dy[cdir];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)continue;
			if (smell[nx][ny].smell != 0)continue;

			if (Map[nx][ny] != 0) {//상어 순서대로 했기때문에 내가 지금 움직이려는 자리에 있는 상어는 무조건 나보다 번호가 작은 순서-> 나를 죽이기
				Map[x][y] = 0;
				isAlive = false;
				cango = true;
				break;
			}
			else {
				Map[x][y] = 0; // 이동 전은 빈 칸으로 바꿈
				Map[nx][ny] = num;
				x = nx; y = ny;
				cango = true;

				// 이동한 상어의 보는 방향을 바꾼다.
				dir = cdir;
			}
			break;
		}

		if (!cango) {
			for (int i = 0; i < 4; ++i) {
				int cdir = shark[num].priority[dir][i];
				int nx = x + dx[cdir], ny = y + dy[cdir];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)continue;
				if (smell[nx][ny].id == num) {
					Map[x][y]=0; // 이동 전은 빈 칸으로 바꿈
					Map[nx][ny]=num;
					x = nx; y = ny;

					// 이동한 상어의 보는 방향을 바꾼다.
					dir = cdir;
					break;
				}
				
			}
		}

		num++;
	}


	/*for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			if (Map[i][j].size() > 0) {
				sort(Map[i][j].begin(), Map[i][j].end());
				int tmp = Map[i][j].front();
				Map[i][j].clear();
				Map[i][j].push_back(tmp);
			}
		}
		이렇게 하면 죽은 상어들 죽은표시를 못하기때문에 로직 수정
	}*/
	int cnt = 0;
	for (auto& s : shark) {
		if (s.isAlive == true) {
			smell[s.x][s.y] = { Map[s.x][s.y],K};
		}
		cnt++;
	}

}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	shark[0].isAlive = false;
	cin >> N >> M >> K;
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			int n;
			cin >> n;
			Map[i][j] = n;
			if (n > 0) {
					shark[n].x = i;
					shark[n].y = j;
					shark[n].isAlive = true;
			}
		}
	}

	for (auto& s : shark) {
		if (!s.isAlive)continue;
		cin >> s.dir;
	}

	for (auto& s : shark) {
		if (!s.isAlive)continue;
		for (int i = 1; i <= 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				cin >> s.priority[i][j];
			}
		}
	}

	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			if (Map[i][j] != 0) {
				smell[i][j] = { Map[i][j],K};
			}
		}
	}
	
	int t = 0;
	while (t <= 1000) {
		bool check = false;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (Map[i][j] != 0 && smell[i][j].id != 1) {
					check = true;
					break;
				}
			}
		}
		if (!check)break;

		Move();

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (Map[i][j] == 0 && smell[i][j].smell > 0) {//상어가 있는칸은 굳이 냄새 지울필요없음
					smell[i][j].smell -= 1;

					if (smell[i][j].smell == 0) {
						smell[i][j].id = 0;
					}
				}
			}
		}
		t++;
		//1000초가 넘었는데도 혼자 안남으면 -1
		if (t > 1000) {
			cout << -1 << '\n';
			return 0;
		}
	}
	result = t;

	cout << result << '\n';
	return 0;
}