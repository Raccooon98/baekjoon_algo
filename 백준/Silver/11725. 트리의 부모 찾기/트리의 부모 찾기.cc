#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N;
vector<int> adj[100005];
int parent[100005];

void DFS(int cur) {
	for (int next : adj[cur]) {
		if (parent[cur] == next)continue;
		parent[next] = cur;
		DFS(next);
	}
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;

	for (int i = 0; i < N - 1; ++i) {
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	DFS(1);//루트가 1이니까
	for (int i = 2; i <= N; ++i)
		cout << parent[i] << '\n';

	return 0;
}