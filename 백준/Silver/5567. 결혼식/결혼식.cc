#include<iostream>
#include<vector>
#include<queue>
using namespace std;
const int MAX = 1005;

int N, M,u,v,result;
int vis[MAX];
vector<int>arr[MAX];
queue<int>q;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;
	for (int i = 0; i < M; ++i) {
		cin >> u >> v;
		arr[u].push_back(v);
		arr[v].push_back(u);
	}
	vis[1] = 1;
	q.push(1);
	while (!q.empty()) {
		auto cur = q.front(); q.pop();

		for (auto nxt : arr[cur]) {
			if (vis[nxt])continue;

			vis[nxt] = vis[cur] + 1;
			q.push(nxt);
		}
	}
	for (int i = 1; i <= N; ++i) {
		if (vis[i] == 2 || vis[i] == 3)result++;
	}
	cout << result << '\n';

	return 0;
}