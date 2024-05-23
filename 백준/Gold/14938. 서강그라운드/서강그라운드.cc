#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
const int INF = 0x7f7f7f7f;
using namespace std;

int N, M, R,result;

vector<pair<int, int>> adj[101];
int d[101],items[101];

void dijkstra(int x) {

	int cnt = 0;
	fill(d, d + N + 1, INF);
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, x });
	d[x] = 0;
	while (!pq.empty()) {
		auto [dist, cur] = pq.top(); pq.pop();
		for (int i = 0; i < adj[cur].size(); i++) {
			auto [ndist, next] = adj[cur][i];
			if (d[next] > dist + ndist) {
				d[next] = dist + ndist;
				pq.push({ d[next], next });
			}
		}
	}
	for (int i = 1; i <= N; ++i)
		if (d[i] <= M)cnt += items[i];
	result = max(result, cnt);
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M >> R;

	for (int i = 1; i <= N; ++i)
		cin >> items[i];

	for (int i = 0; i < R; ++i) {
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back({ c,b });
		adj[b].push_back({ c,a });
	}

	for (int i = 1; i <= N; ++i)
		dijkstra(i);

	cout << result;

	return 0;
}