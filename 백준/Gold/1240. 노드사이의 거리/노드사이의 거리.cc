#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

const int SIZE = 1005;
vector<pair<int, int>> adj[SIZE];
int dist[SIZE] = { 0, };

int BFS(int start, int end) {
	int sum = 0;
	fill(dist, dist + SIZE, -1);

	queue<int> q;
	q.push(start);
	dist[start] = 0;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();
		for (auto [nxt,nd] : adj[cur]) {
			if (dist[nxt] != -1) continue;
			dist[nxt] = dist[cur] + nd;
			q.push(nxt);
		}
	}

	return dist[end];
}

int main() {
	cin.tie(0)->sync_with_stdio(false);

	int N, M;
	cin >> N >> M;

	for (int i = 0; i < N - 1; ++i) {
		int st, en, dist;
		cin >> st >> en >> dist;
		adj[st].push_back({ en,dist });
		adj[en].push_back({ st,dist });
	}

	for (int i = 0; i < M; ++i) {
		int a, b;
		cin >> a >> b;
		cout << BFS(a, b) << "\n";
	}

}