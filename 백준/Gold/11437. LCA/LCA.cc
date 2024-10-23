#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;

int N,M,a,b;
queue<int>q;
vector<int> node[50001];
bool check[50001];
int parent[50001];
int depth[50001];

int LCA(int a, int b) {
	if (depth[a] > depth[b])swap(a, b);

	while (depth[a] != depth[b])
		b = parent[b];

	while (a != b) {
		a = parent[a];
		b = parent[b];
	}

	return a;
}

int main(void)
{
	cin.tie(NULL)->sync_with_stdio(false);

	
	cin >> N;
	for (int i = 0; i < N-1; ++i) {

		cin >> a >> b;
		node[a].push_back(b);
		node[b].push_back(a);
	}

	check[1] = 1;//true:1 false:0으로 대체 가능
	q.push(1);

	while (!q.empty()) {
		int x = q.front();
		q.pop();

		for (int i = 0; i <node[x].size(); i++) {
			int cur = node[x][i];
			if (!check[cur])//지금 노드를 방문한적이 없으면
			{
				depth[cur] = depth[x] + 1;
				check[cur] = 1;
				parent[cur] = x;
				q.push(cur);
			}
		}
	}

	cin >> M;

	for (int i = 0; i < M; ++i) {
		cin >> a >> b;
		cout << LCA(a, b) << '\n';
	}

}