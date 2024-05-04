//높이 낮은곳으로 이동한다는 조건 고려하면 DP로 칸마다 이 칸에 올 수 있는 경우를 숫자로 저장하는게 제일 괜찮아보임
//목표 지점까지 도착하는건 DFS로 쭉 탐색

#include<iostream>
using namespace std;

int N, M, result;

int Map[510][510];
int DP[510][510];

int dx[]{ 1,-1,0,0 };
int dy[]{ 0,0,1,-1 };

int DFS(int x, int y) {
	//우측하단점 도착하면
	if (x == N - 1 && y == M - 1)
		return 1;
	//-1이면 이 점에 갈 수 없다는 뜻
	if (DP[x][y] != -1)return DP[x][y];

	DP[x][y] = 0;
	for (int i = 0; i < 4; ++i) {
		int nx = x + dx[i], ny = y + dy[i];
		if (nx < 0 || ny < 0 || nx >= N || ny >= M)continue;
		if (Map[nx][ny] < Map[x][y]) {
			DP[x][y] = DP[x][y] + DFS(nx, ny);
		}
	}
	return DP[x][y];
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;

	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < M; ++j) {
			cin >> Map[i][j];
			DP[i][j] = -1;
		}
	}

	result = DFS(0, 0);
	cout << result<<'\n';

	return 0;
}