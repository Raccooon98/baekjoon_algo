//1을 만드는건 1 1개 2를 만드는건 1+1, 2 로 2개, 3을 만드는건 1+1+1, 1+2,2+1, 3 4개
//위 내용을 반복하면 4는 7개  5는 13개.... 이어짐
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int testcase = 0;
int dp[12];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	for (int i = 4; i <= 10; ++i) {
		dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
	}

	cin >> testcase;
	for (int t = 0; t < testcase; ++t) {
		int n;
		cin >> n;
		cout << dp[n]<<'\n';
	}
	return 0;
}