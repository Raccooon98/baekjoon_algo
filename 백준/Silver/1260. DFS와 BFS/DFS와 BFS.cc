#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;

int N, M, s;
vector<int> graph[1005];
bool vis[1005];

void DFS(int cur) {
	vis[cur] = true;
	cout << cur << ' ';
	for (auto a : graph[cur]) {
		if (vis[a])continue;
		DFS(a);
	}
}

void BFS() {
	queue<int> q;
	q.push(s);
	vis[s] = true;
	while (!q.empty()) {
		int cur = q.front();
		cout << cur << ' ';
		q.pop();

		for (auto a : graph[cur]) {
			if (vis[a])continue;
			q.push(a);
			vis[a] = true;
		}
	}
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M >> s;
	for (int m = 0; m < M; ++m) {
		int u, v;
		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}

	for (int i = 1; i <= N; i++)
		sort(graph[i].begin(), graph[i].end());
	DFS(s);
	cout << '\n';
	memset(vis, 0, sizeof(vis));
	BFS();

	return 0;
}