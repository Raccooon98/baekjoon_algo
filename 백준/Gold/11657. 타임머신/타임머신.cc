#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

const long long INF = 1e18;
int N, M;
long long d[500];
vector<pair<int, int>> adj[500];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	cin >> N >> M;
	for (int i = 0; i < M; ++i) {
		int a, b, c;
		cin >> a >> b >> c;
		adj[a - 1].push_back({ b - 1,c });
	}
	bool is_minuscycle = false;
	fill(d, d + N, INF);
	d[0] = 0;
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			for (auto& [next, D] : adj[j]) {
				if (d[j] != INF && d[next] > d[j] + D) {
					d[next] = d[j] + D;
					if (i == N - 1) is_minuscycle = true;
				}
			}
		}
	}
	if (is_minuscycle)cout << -1;
	else {
		for (int i = 1; i < N; ++i)
			cout << (d[i] != INF ? d[i] : -1) << '\n';
	}
	
	return 0;
}