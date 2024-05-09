#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

int N, M;
int deg[32005];
vector<int> adj[32005];
queue<int> q;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;
	for (int m = 0; m < M; ++m) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		deg[b]++;//indegree 개수 체크
	}

	for (int i = 1; i <= N; ++i)
		if (deg[i] == 0)q.push(i);

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		cout << cur << ' ';
		for (auto next : adj[cur]) {
			deg[next]--;
			if (deg[next] == 0)q.push(next);
		}
	}
}