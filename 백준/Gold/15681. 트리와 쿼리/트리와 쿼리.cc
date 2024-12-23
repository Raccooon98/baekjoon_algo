#include <iostream>
#include<algorithm>
#include<vector>
using namespace std;
const int MAX = 100001;

int N, R, Q;
vector<int> v[MAX];
bool vis[MAX];
int arr[MAX];

int DFS(int n) {
	if (arr[n] != 0)
		return arr[n];

	vis[n] = true;
	int num = 1;

	for (auto next : v[n]) {
		if (vis[next])
			continue;
		num += DFS(next);
	}

	arr[n] = num;

	return num;
}

int main(void)
{
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> R >> Q;

	for (int i = 0; i < N - 1; ++i) {
		int U, V;
		cin >> U >> V;
		v[U].push_back(V);
		v[V].push_back(U);
	}

	arr[R] = DFS(R);
	for (int i = 0; i < Q; ++i) {
		int U;
		cin >> U;
		cout << arr[U]<<'\n';
	}

	return 0;
}