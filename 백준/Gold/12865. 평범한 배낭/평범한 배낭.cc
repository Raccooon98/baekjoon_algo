//냅색 DP문제
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, K;
long long dp[1000005];

int main(void)
{
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> K;

	for (int i = 0; i < N; ++i) {
		int w, v;
		cin >> w >> v;
		for (int j = K; j >= w; --j) {
			dp[j] = max(dp[j], dp[j - w] + v);
		}
	}

	cout << dp[K] << '\n';

	return 0;
}