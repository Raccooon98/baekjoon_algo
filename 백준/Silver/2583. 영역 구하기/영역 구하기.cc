//N이 가로 M이 세로 BFS로 그림 구역 세는것 처럼 하면 될듯
#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>
#define MAX 100

int board[MAX][MAX] = {0,};
bool vis[MAX][MAX] = { 0, };
using namespace std;
int M, N, K,cnt=0;
queue<pair<int, int>> q;
vector<int> w;

void BFS() {
	int dx[] = { 1,0,-1,0 }, dy[] = { 0,-1,0,1 };
	cnt = 1;
	while (!q.empty()) {
		int y = q.front().first;
		int x = q.front().second;
		q.pop();

		for (auto i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if (!vis[ny][nx]) {
				q.push({ ny,nx });
				vis[ny][nx] = true;
				//영역의 넓이 +1
				cnt++; 
			}
		}
	}
	w.push_back(cnt);

}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	int x1, x2, y1, y2, result = 0;
	

	cin >> M >> N >> K;
	for (auto i = 0; i < K; ++	i) {
		cin >> x1 >> y1 >> x2 >> y2;

		//아이디어가 잘 생각이 안남
		for (auto t = y1; t < y2; ++t) {
			for (auto  s= x1; s < x2; ++s) {
				vis[t][s] = 1;
			}
		}
	}
		
	for (auto i = 0; i < M; ++i) {
		for (auto j = 0; j < N; ++j) {
			if (!vis[i][j]) {
				q.push({ i,j });
				vis[i][j] = true;
				BFS();
				result++;
			}
		}
	}

	sort(w.begin(), w.end());

	cout << result << '\n';
	for (auto num : w) {
		cout << num << '\n';
	}
	return 0;
}