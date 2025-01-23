#include <iostream>
#include <vector>
#include<string>
using namespace std;
const int MOD = 1000000;

int dp[5001];

int main() {
	string str;
	cin >> str;
	
	if (str.empty() || str[0] == '0') {
		cout << "0\n";
		return 0;
	}
	
	int n = str.length();

	if (str[0] == '0') return 0;
	dp[0] = dp[1] = 1;

	for (int i = 2; i <= n; ++i) {
		if (str[i - 1] != '0') dp[i] = dp[i - 1] % MOD;

		int tmp = (str[i - 2] - '0') * 10 + (str[i - 1] - '0');
		if (tmp >= 10 && tmp <= 26)
			dp[i] = (dp[i] + dp[i - 2]) % MOD;
	}

	cout << dp[n]<<'\n';
	return 0;
}