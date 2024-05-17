//0->0 1개 1->1 1개 2-> 1+1,2 2개  3-> 1+1+1, 1+2, 2+1, 3 4개   4-> 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1,4 7개
//dp[i] = dp[i-1]+dp[i-2]+dp[i-3]
#include<iostream>
#include<algorithm>
using namespace std;
const int MOD = 1'000'000'009;
long long dp[1000001];
int T,N;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	dp[0] = 1;
	dp[1] = 1;
	dp[2] = 2;
	for (int i = 3; i <= 1000000; ++i) {
		dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
	}
	cin >> T;
	while (T--) {
		cin >> N;
		cout << dp[N] << '\n';
	}
	return 0;
}
