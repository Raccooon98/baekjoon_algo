#include <iostream>
#include<queue>
using namespace std;
const int INF = 1000000000;

int N;
int Map[130][130];
int vis[130][130];
int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };


int main()
{
	cin.tie(NULL)->sync_with_stdio(false);
	int cnt = 1;
	while (1) {
		cin >> N;
		if (N == 0) return 0;

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				vis[i][j] = INF;
				cin >> Map[i][j];
			}
		}

		queue<pair<int, int>> q;
		q.push({ 0,0 });
		vis[0][0] = Map[0][0];
		while (!q.empty()) {
			int x = q.front().first;
			int y = q.front().second;
			q.pop();

			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

				if (vis[nx][ny] > vis[x][y] + Map[nx][ny]) {
					vis[nx][ny] = vis[x][y] + Map[nx][ny];
					q.push({ nx,ny });
				}
			}
		}
		cout << "Problem " << cnt++ << ": " << vis[N - 1][N - 1] << '\n';
	}

	return 0;
}