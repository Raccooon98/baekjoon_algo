#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;

int T, W,result;
int order[1005];
int dp[3][35][1005];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	//vector<int> order(T+1);
	cin >> T >> W;
	for (int i = 1; i <= T; ++i) {
		cin >> order[i];
	}
	memset(dp, -1, sizeof(dp));

	dp[1][W][0] = 0;

	for (int t = 0; t < T; ++t) {
		for (int c = 0; c <= W; ++c) {
			for (int p = 1; p <= 2; ++p) {
				if (dp[p][c][t] >= 0) {
					int nxt = order[t + 1];
					if (p == nxt)
						dp[p][c][t + 1] = dp[p][c][t] + 1;
					else {
						if (c != 0) {
							dp[nxt][c - 1][t + 1] = max(dp[nxt][c - 1][t + 1], dp[p][c][t] + 1);
						}

						dp[p][c][t + 1] = dp[p][c][t];
					}
				}
			}
		}
	}

	result = 0;
	for (int p = 1; p <= 2; ++p) {
		for (int t = 1; t <= T; ++t) {
			result = max(result, dp[p][0][t]);
		}
		for (int i = 0; i <= W; ++i) {
			result = max(result, dp[p][i][T]);
		}
	}

	cout << result << '\n';

	return 0;
}