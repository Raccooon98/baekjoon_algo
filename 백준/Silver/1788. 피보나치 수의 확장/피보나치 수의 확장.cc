//음수로 가면 기존 피보나치랑 같은 수에서 n이 짝수일때만 결과가 음수가 된다.
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;
const int MOD = 1'000'000'000;
const int MAX = 1'000'001;

long long DP[MAX];
int N;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	int check = 1;
	cin >> N;

	if (N < 0) {
		N *= -1;
		if (N % 2 == 0) check = -1;
	}

	if (N == 0)check = 0;

	DP[0] = 0;
	DP[1] = 1;
	for (int i = 2; i <= N; ++i)
		DP[i] = (DP[i - 1] + DP[i - 2]) % MOD;

	cout << check << '\n' << DP[N] << '\n';

	return 0;
}