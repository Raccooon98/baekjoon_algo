#include<iostream>
#include<cstring>
using namespace std;
const int SIZE = 10005;

int N, M; 
int coin[25]; 
int dp[SIZE];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	int TC;
	cin >> TC;
	while (TC--) {
		memset(dp, 0, sizeof(dp));
		memset(coin, 0, sizeof(coin));
		cin >> N;
		for (int i = 1; i <= N; ++i) {
			cin >> coin[i];
		}
		cin >> M;
		dp[0] = 1;
		for (int i = 1; i <= N; ++i) {
			for (int j = coin[i]; j <= M;++j) {
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}

		cout << dp[M] << '\n';
	}

	return 0;
}