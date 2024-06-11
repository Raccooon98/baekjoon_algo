#include<iostream>
#include<algorithm>
using namespace std;
using ll = long long;

ll state[15];

int N, M;
int result = 0x3f3f3f3f;
int maxcnt = 0;

int countBit(ll bit) {
	int cnt = 0;

	while (bit) {
		cnt += bit & 1;
		bit >>= 1;
	}
	return cnt;
}

void func(int idx, ll bit, int cnt) {
	int bittosong = countBit(bit);

	if (bittosong > maxcnt) {
		maxcnt = bittosong;
		result = cnt;
	}
	else if (bittosong == maxcnt)
		result = min(result, cnt);

	if (idx == N)return;

	func(idx + 1, bit | state[idx], cnt + 1);

	func(idx + 1, bit, cnt);
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;

	for (int i = 0; i < N; ++i) {
		string name, detail;
		cin >> name >> detail;

		for (int j = 0; j < M; ++j) {
			if(detail[j]=='Y'){
				state[i] |= (1LL << (M - 1 - j));
			}
		}
	}

	func(0, 0, 0);

	if (!maxcnt)cout << -1;
	else cout << result;
}