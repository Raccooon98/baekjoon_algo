#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
const int MAX = 100005;
using namespace std;
using ll = long long;
const ll INF = 0x3f3f3f3f3f3f3f;

int N, M,K;

priority_queue<pair<ll, ll>, vector<pair<ll, ll>>, greater<pair<ll, ll>>> pq;
vector<pair<ll, ll>> adj[MAX];
ll d[100005];

void dijkstra() {
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

	cin >> N >> M>>K;

	while (M--) {
		ll a, b, c;
		cin >> a >> b >> c;
		adj[b].push_back({ c,a });
	}

	ll maxnum = -1;

	fill(d, d + N + 3, INF);

	for (int i = 0; i < K; ++i) {
		int n;
		cin >> n;
		d[n] = 0;
		pq.push({ d[n],n });
	}

	dijkstra();

	int result = -1;
	for (int i = 1; i <= N; ++i) {
		if (maxnum < d[i]) {
			result = i;
			maxnum = d[i];
		}
	}

	cout << result << '\n' << maxnum;

	return 0;
}