#include <iostream>
#include <vector>
using namespace std;
const int MAX = 100'001;

vector<int> v[MAX];
bool vis[MAX];
int arr[MAX];
int N, R, Q, U, V;

int DFS(int n) {
	if (arr[n] != 0) return arr[n];
	vis[n] = 1;
	int val = 1;

	for (auto a : v[n]) {
		int nxt = a;
		if (vis[nxt])continue;
		val += DFS(nxt);
	}

	arr[n] = val;
	return val;
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> R >> Q;

	for (int i = 0; i < N-1; ++i) {
		cin >> U >> V;
		v[U].push_back(V);
		v[V].push_back(U);
	}

	arr[R] = DFS(R);
	for (int i = 0; i < Q; ++i) {
		cin >> U;
		cout << arr[U] << '\n';
	}

	return 0;
}