//다익스트라인듯
#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
const int MAX = 1005;
const int INF = 0x7f7f7f7f;
using namespace std;

int N, M;

vector<pair<int, int>> adj[MAX];
int d[MAX], items[MAX];

void dijkstra(int x) {

	int cnt = 0;
	fill(d, d + N + 1, INF);
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, x });
	d[x] = 0;

	while (!pq.empty()) {
		auto [dist, cur] = pq.top(); pq.pop();
		if (d[cur] < dist) continue;

		for (auto [ndist, next] : adj[cur]) {
			if (d[next] > dist + ndist) {
				d[next] = dist + ndist;
				pq.push({ d[next], next });
			}
		}
	}
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;
	adj[0].push_back({ 0,0 });

	while (M--) {
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back({ c,b });
	}

	int st, en;
	cin >> st >> en;
	dijkstra(st);
	cout << d[en]<<'\n';

	return 0;


}
