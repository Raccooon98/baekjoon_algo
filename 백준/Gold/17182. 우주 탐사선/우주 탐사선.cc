#include <iostream>
#include <algorithm>
using namespace std;
const int MAX = 0x7f7f7f7f;
int N, K, ans = MAX;
bool vis[15];
int arr[15][15];

void dfs(int idx, int dist, int planet) {
	if (ans < dist) return;
	if (planet == N) {
		ans = min(ans, dist);
		return;
	}
	for (int i = 0; i < N; i++) {
		if (vis[i]) continue;
		vis[i] = true;
		dfs(i, dist + arr[idx][i], planet + 1);
		vis[i] = false;
	}
}

int main() {
	cin.tie(NULL)->sync_with_stdio(false);
	cin >> N >> K;
	for (int i = 0; i < N; ++i)
		for (int j = 0; j < N; ++j)
			cin >> arr[i][j];

	vis[K] = true;

	for (int k = 0; k < N; ++k)
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				if (arr[i][j] > arr[i][k] + arr[k][j])
					arr[i][j] = arr[i][k] + arr[k][j];
	dfs(K, 0, 1);
	cout << ans;
	return 0;
}