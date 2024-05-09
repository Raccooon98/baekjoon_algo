//n=2 일때 10, 21, 12, 32, 23, 43, 34, 54, 45, 65, 56, 76, 67, 87, 78, 98
//뒷자리수를 알면 앞자리수는 +-1이다.

#include<iostream>
#include<cmath>
#include<algorithm>
using namespace std;

long long  N, result;
long long dp[101][10];


int  main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	for (int i = 1; i <= 9; ++i) {
		dp[1][i] = 1;
	}

	for (int i = 2; i <= N; ++i) {
		for (int j = 0; j <= 9; ++j) {
			if (j == 0) {
				dp[i][0] = dp[i - 1][j + 1];
			}
			else if (j == 9) {
				dp[i][9] = dp[i - 1][j - 1];
			}
			else {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1'000'000'000;
			}
		}
	}

	for (auto a : dp[N]) {
		result = (result + a) % 1000000000;
	}

	cout << result << '\n';

	return 0;

}