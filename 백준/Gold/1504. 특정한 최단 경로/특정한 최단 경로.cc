#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
const int INF = 0x7f7f7f7f;
using namespace std;

int N, E,result,v1,v2;
vector<pair<int, int>> adj[801] ;
int d[805];

int dijkstra(int x, int y) {
	fill(d, d + N+1, INF);
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, x });
	d[x] = 0;
	while (!pq.empty()) {
		auto [dist,cur] = pq.top(); pq.pop();
		for (int i = 0; i < adj[cur].size(); i++) {
			auto[ ndist,next] = adj[cur][i];
			if (d[next] > dist + ndist) {
				d[next] = dist + ndist;
				pq.push({ d[next], next });
			}
		}
	}
	return d[y];
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	int num1 = INF, num2 = INF;
	cin >> N >> E;
	for (int i = 0; i < E; ++i) {
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back({ c,b });
		adj[b].push_back({ c,a });
	}
	cin >> v1 >> v2;
	if (dijkstra(1, v1) == INF || dijkstra(v1, v2) == INF || dijkstra(v2, N) == INF)
		num1 = INF;
	else
		num1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);

	if (dijkstra(1, v2) == INF || dijkstra(v2, v1) == INF || dijkstra(v1, N) == INF)
		num2 = INF;
	else
		num2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

	if (num1 == INF && num2 == INF)
		cout << -1 << '\n';
	else
		cout << min(num1, num2)<<'\n';

	return 0;
}