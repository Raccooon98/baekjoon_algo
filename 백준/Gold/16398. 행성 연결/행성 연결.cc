//1 ≤ Cij ≤ 100,000,000 이고 1<N<1000이니까 결과값이 int 범위 벗어나는거 조심
//각 행성을 연결했을때 비용이 최소->최소스패닝트리 MST??? 맞을듯 그러면 union find로 크루스칼 해보기

#include<iostream>
#include<vector>
#include<queue>
#include<tuple>
#include<algorithm>
using namespace std;
const int INF=0x7f7f7f7f;

long long result;
int parent[1005],Rank[1005];
int arr[1005][1005];
int N;

int find(int x) {
	if (parent[x] == x)
		return x;
	else {
		parent[x] = find(parent[x]);
		return parent[x];
	}
}


void Union(int x, int y) {
	x = find(x);
	y = find(y);

	if (x == y) return; 
	if (Rank[x] < Rank[y]) swap(x, y);
	parent[y] = x; 
	if (Rank[x] == Rank[y]) Rank[x]++; 
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	parent[0] = 0;
	cin >> N;
	

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			cin >> arr[i][j];
		}
		parent[i] = i;
	}

	vector<tuple<int, int, int>> adj;

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			adj.push_back({ arr[i][j],i,j });
		}
		
	}

	sort(adj.begin(), adj.end());

	for (auto& [cost,x,y] : adj) {
		if (find(x) == find(y))continue;
		result += cost;
		Union(x, y);
	}

	cout << result << '\n';

	return 0;
}