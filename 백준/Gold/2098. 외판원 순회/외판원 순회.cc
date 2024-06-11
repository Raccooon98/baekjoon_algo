#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
const int INF= 1000000000;

int N, W[16][16], dp[16][1 << 16];

int TSP(int cur, int vis) {
	int& ret = dp[cur][vis];
	if (ret != -1)return ret;

	if(vis==(1<<N)-1){
		if (W[cur][0] != 0)return W[cur][0];
		return INF;
	}

	ret = INF;
	for (int i = 0; i < N; ++i) {
		if (vis & (1 << i) || W[cur][i] == 0)continue;

		ret = min(ret, TSP(i, vis | (1 << i)) + W[cur][i]);
	}

	return ret;
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			cin >> W[i][j];
		}
	}

	memset(dp, -1, sizeof(dp));
	cout << TSP(0, 1);
}