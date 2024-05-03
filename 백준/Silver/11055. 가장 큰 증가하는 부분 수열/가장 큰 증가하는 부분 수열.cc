//어제 풀었던 DP문제 연속합이랑 비슷한것 같아서 DP로 시도
//n의 최대가 1000이라서 이중포문으로 비교하면서 풀어도 될것 같음 (100만밖에 안나옴)
#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int N,Maxnum=0;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	vector<int> dp(N), arr(N);
	for (int i = 0; i < N; ++i) {
		cin >> arr[i];
	}

	for (int i = 0; i < N; ++i) {
		dp[i] = arr[i];
		for (int j = 0; j < N; ++j) {
			if (arr[j] < arr[i] && dp[i] < dp[j] + arr[i])
				dp[i] = dp[j] + arr[i];
		}
		Maxnum = max(Maxnum, dp[i]);
	}
	

	cout << Maxnum << '\n';

	return 0;
}
