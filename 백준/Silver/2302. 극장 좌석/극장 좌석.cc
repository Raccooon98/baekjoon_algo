
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;

int N, M;
int dp[45];
vector<int> mvp;
vector<long long> results;
long long result=1;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	cin >> N >> M;
	int m = M;
	while (m--) {
		int a;
		cin >> a;
		mvp.push_back(a);
	}

	dp[0] = 1;
	dp[1] = 1;
	dp[2] = 2;

	for (int i = 3; i <= N; ++i)
		dp[i] = dp[i - 2] + dp[i - 1];

	int st = 0, en = 0;
	for (auto a : mvp) {
		en = a;
		int len = en - st-1;
		results.push_back(dp[len]);
		st = en;
	}
	results.push_back(dp[N-st]);
	for (auto num : results) {
		result *= num;
	}

	cout << result << '\n';

	return 0;
}