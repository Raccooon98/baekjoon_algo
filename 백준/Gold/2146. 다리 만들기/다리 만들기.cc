//짠돌이 대통령이 비용삭감을 위해 가장 짧은 다리를 만드는 문제.. 
// 다리를 어디에 몇칸 세울지 정하는 기준이 섬의 크기가 아니고 그냥 제일 가까운 섬끼리 연결..
//일단 섬이 몇개인지 세기, 각 섬을 구분할수 있게 만들기 1,2,3,4...
//또 다리 길이 구하고 최솟값 저장해놨다가 출력하기?

#include<iostream>
#include<algorithm>
#include<cstring>
#include<queue>
#include<vector>
using namespace std;

int N,result=1000000000;
int Map[101][101];
int vis[101][101];

int dx[] = {1,0,-1,0};
int dy[] = {0,-1,0,1};

void count_island(int x,int y, int num) {
	queue<pair<int, int>> q;
	q.push({ x,y });
	vis[x][y] = 1;
	Map[x][y] = num;

	while (!q.empty()) {
		auto cur = q.front();
		q.pop();

		for (auto i = 0; i < 4; ++i) {
			int nx = cur.first + dx[i];
			int ny = cur.second + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)continue;
			if (!vis[nx][ny] && Map[nx][ny] == -1) {
				vis[nx][ny] = 1;
				Map[nx][ny] = num;
				q.push({ nx,ny });
			}
		}
	}
}

int BFS(int num) {
	queue<pair<int, int>> q;
	int sum = 0;
	for (auto i = 0; i < N; ++i) {
		for (auto j = 0; j < N; ++j) {
			if (Map[i][j] == num) {
				vis[i][j] = 1;
				q.push({ i,j });
			}
		}
	}

	while (!q.empty()) {
		int size = q.size();
		for (auto j = 0; j < size; ++j) {//섬의 모든 지점에서 다리를 놓기 시작한다고 생각하고 탐색 하는 방법 끝부분에서만 탐색을 하고 싶은데 더 간결한 방법이 있으면 좋겠다.
			auto cur = q.front();
			q.pop();

			for (auto i = 0; i < 4; ++i) {
				int nx = cur.first + dx[i];
				int ny = cur.second + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)continue;//맵 벗어나면 넘어가기
				if (Map[nx][ny] != 0 && Map[nx][ny] != num) return sum;//넘겨받은 번호가 아니고 0이 아니면 여태까지 이은 다리의 길이 리턴
				else if (Map[nx][ny] == 0 && !vis[nx][ny]) {//방문 안했고 바다면 계속 탐색
					vis[nx][ny] = 1;
					q.push({ nx,ny });
				}
			}
		}
		sum++;
	}
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	int cnt = 1;
	cin >> N;
	for (auto i = 0; i < N; ++i) {
		for (auto j = 0; j < N; ++j) {
			cin >> Map[i][j];
			if (Map[i][j] == 1)
				Map[i][j] = -1;
		}
	}
	//섬 갯수 세듯이 진행하면서 올려준 카운트 같이 넘겨서 구역별로 다른 숫자 부여해놓기
	for (auto i = 0; i < N; ++i) {
		for (auto j = 0; j < N; ++j) {
			if (Map[i][j] == -1 && !vis[i][j]) {
				count_island(i, j, cnt);
				cnt++;
			}
		}
	}

	for (auto i = 1; i < cnt; ++i) {
		memset(vis, 0, sizeof(vis));
		result = min(result, BFS(i));
	}

	cout << result<<'\n';
	return 0;
}