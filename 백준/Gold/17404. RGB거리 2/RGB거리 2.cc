#include <iostream>
#include <algorithm>
const int MAX = 1000 * 1000 + 1;
using namespace std;

int cost[1001][3];
int N;
int r, g, b;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	int ans = MAX;
	cin >> N;
	for (int i = 1; i <= N; ++i) {
		cin >> r >> g >> b;
		cost[i][0] = r;
		cost[i][1] = g;
		cost[i][2] = b;
	}

	for (int start = 0; start <= 2; start++) {
		int dp[1001][3];

		for (int j = 0; j <= 2; ++j) {
			if (j == start) 
				dp[1][start] = cost[1][start];
			else 
				dp[1][j] = MAX;
		}

		for (int i = 2; i <= N; ++i) {
			dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			dp[i][2] = min(dp[i - 1][1], dp[i - 1][0]) + cost[i][2];
		}

		for (int j = 0; j <= 2; ++j) {
			if (j == start) 
				continue;

			ans = min(ans, dp[N][j]);
		}
	}

	cout << ans<<'\n';
	return 0;
}