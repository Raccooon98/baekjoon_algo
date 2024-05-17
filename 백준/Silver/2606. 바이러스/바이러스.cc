#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N, M, cnt;
vector<int> adj[105];
bool vis[105];

void DFS(int a) {
	vis[a] = true;
	for (int i = 0; i < adj[a].size(); ++i) {
		int n = adj[a][i];
		if (!vis[n]) {
			DFS(n);
			cnt++;
		}
	}
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M ;

	while (M--) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	DFS(1);
	cout << cnt << '\n';

	return 0;

}