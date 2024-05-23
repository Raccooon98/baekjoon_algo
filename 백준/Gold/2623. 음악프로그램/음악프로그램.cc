//일단 꼼수를 부려보자면 스페셜 저지가 붙었긴 때문에 위상정렬을 고려해 볼 수 있다.

#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int N, M;
int indegree[1002];
vector<int> adj[1002];
vector<int> result;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;
	while (M--) {
		int a,b,c;
		cin >> a;
		if (a == 0) continue;
		cin >> b;
		if (a == 1) continue;

		for (int i = 0; i < a - 1; ++i) {
			cin >> c;
			adj[b].push_back(c);
			indegree[c]++;
			b = c;
		}
	}
	queue<int> q;

	for (int i = 1; i <= N; ++i) {
		if (indegree[i] == 0)
			q.push(i);
	}

	while (!q.empty()) {
		int cur = q.front(); q.pop();
		result.push_back(cur);

		for (int i = 0; i < adj[cur].size(); i++) {
			int next = adj[cur][i];
			indegree[next]--;
			if (indegree[next] == 0) {
				q.push(next);
			}
		}
	}

	if ((int)result.size() != N) {
		cout << 0 << '\n';
		return 0;
	}

	else {
		for (int i = 0; i < N; i++) {
			cout << result[i] << '\n';
		}
	}

	return 0;
}