#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N, K,sum;
vector<int> coin;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	
	cin >> N >> K;
	for (int i = 0; i < N; ++i) {
		int a;
		cin >> a;
		coin.push_back(a);
	}

	sort(coin.begin(), coin.end(), greater<int>());

	for (auto& v : coin) {
		if (K / v >= 1) {
			sum += K / v;
			K %= v;
		}
	}

	cout << sum;
	return 0;
}