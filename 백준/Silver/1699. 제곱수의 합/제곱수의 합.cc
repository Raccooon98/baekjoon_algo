#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
const int MAX = 100'005;

int N;
int dp[MAX];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	for (int i = 0; i <= N; ++i) {
		dp[i] = i;
	}

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j * j <= i; ++j){
			dp[i] = min(dp[i], dp[i - j * j] + 1);
		}
	}

	cout << dp[N] << '\n';
	return 0;
}