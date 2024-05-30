#include<iostream>
#include<cstring>
#include<string>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;
const int MAX = 105;
const int INF = 0x7f7f7f7f;

int N,M,result;
int arr[MAX][MAX];
int d[MAX][MAX];

int dx[]{ 0,0,1,-1 };
int dy[]{ 1,-1,0,0 };

void BFS() {
	queue<pair<int, int>> q;
	q.push({ 0,0 });
	d[0][0] = 0;

	while (!q.empty()) {
		auto [x, y] = q.front();
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if (arr[nx][ny] == 1) {
				if (d[nx][ny] > d[x][y] + 1) {
					d[nx][ny] = d[x][y] + 1;
					q.push({ nx,ny });
				}
			}
			else if (arr[nx][ny] == 0) {
				if (d[nx][ny] > d[x][y]) {
					d[nx][ny] = d[x][y];
					q.push({ nx,ny });
				}
			}
		}
	}

}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> M >> N;
	for (int i = 0; i < N; ++i) {
		string s;
		cin >> s;
		for (int j = 0; j < M; ++j) {
			arr[i][j] = s[j] - '0';
			d[i][j] = INF;
		}
	}

	BFS();

	cout << d[N - 1][M - 1] << '\n';

	return 0;

}