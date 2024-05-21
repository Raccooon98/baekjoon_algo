//1 ≤ M ≤ 2,000,000,000랑 높이는 1,000,000,000보다 작거나 같은 양의 정수이므로 long long 필요
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
using ll = long long;

int N, M, MAX = 0;
ll tree[1000005];



int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;
	for (int i = 0; i < N; ++i) {
		cin >> tree[i];
	}

	sort(tree, tree + N);

	ll st = 0;
	ll en = tree[N - 1];
	while (st <= en) {
		ll sum = 0;
		ll mid = (st + en) / 2;

		for (int i = 0; i < N; ++i)
			if (tree[i] - mid > 0)
				sum += tree[i] - mid;

		if (sum >= M) {
			MAX = mid;
			st = mid + 1;
		}
		else
			en = mid - 1;
	}

	cout << MAX;

	return 0;
}