#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;
const int INF = 0x7f7f7f7f;

int V, E, st;
vector<pair<int, int>> adj[20005];
int d[20005];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> V >> E >> st;
	fill(d, d + V + 1, INF);

	for (int e = 0; e < E; ++e) {
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back({ c,b });
	}
	priority_queue < pair<int, int>, vector < pair<int, int>>, greater<pair<int, int>>> pq;
	d[st] = 0;

	pq.push({ d[st],st });
	while (!pq.empty()) {
		auto [x, y] = pq.top(); pq.pop();
		if (d[y] != x)continue;
		for (auto&[nx,ny] : adj[y]) {
			if (d[ny] <= d[y] + nx)continue;
			d[ny] = d[y] + nx;
			pq.push({ d[ny],ny });
		}
	}

	for (int i = 1; i <= V; ++i) {
		if (d[i] == INF)cout << "INF\n";
		else cout << d[i] << "\n";
	}

	return 0;
}