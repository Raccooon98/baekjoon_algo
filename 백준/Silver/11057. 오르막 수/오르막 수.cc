#include<iostream>
using namespace std;
const int MOD = 10007;

int dp[1005][10];

int N,result;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	
	cin >> N;

	for (int i = 0; i < 10; ++i) {
		dp[1][i] = 1;
	}

	for (int i = 2; i <= N; ++i) {
		for (int j = 0; j < 10; ++j) {
			if (j == 0) {
				dp[i][0] = 1;
				continue;
			}

			dp[i][j] = (dp[i - 1][j] + dp[i][j - 1])%MOD;
		}
	}

	for (int i = 0; i < 10; i++)
		result += dp[N][i];

	cout << result % MOD;

	return 0;
}