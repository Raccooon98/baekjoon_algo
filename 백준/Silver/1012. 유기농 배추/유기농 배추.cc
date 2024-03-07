#include<iostream>
#include<queue>
using namespace std;

int dx[] = {1,0,-1,0};
int dy[] = {0,-1,0,1};

int T, N, M, K = 0;
int map[50][50] = { 0, };
bool vis[50][50] = { 0, };
queue<pair<int, int>> q;

void BFS() {
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		vis[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
			if (!vis[nx][ny] && map[nx][ny] == 1) {
				vis[nx][ny] = 1;
				q.push({ nx,ny });
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	cin >> T;
	for (int i = 0; i < T; i++) {
		//매 케이스마다 초기화
		while (!q.empty()) q.pop();
		for (int t= 0; t < M; t++) {
			for (int k = 0; k < N; k++) {
				vis[t][k] = 0;
				map[t][k] = 0;
			}
		}
		//입력받는 부분
		cin >> M >> N >> K;
		int cnt = 0;
		for (int j = 0; j < K; j++) {
			int x, y;
			cin >> x >> y;
			map[x][y] = 1;
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !vis[i][j]) {
					q.push({ i,j });
					cnt++;
					BFS();
				}
			}
		}
		cout << cnt << '\n';
	}
}