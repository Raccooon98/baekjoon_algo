#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;
using ll = long long;

ll N, M,result;
priority_queue<ll,vector<ll>,greater<ll>> pq;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;

	for (int i = 0; i < N; ++i) {
		ll a;
		cin >> a;
		pq.push(a);
	}

	for (int m = 0; m < M; ++m) {
		ll a = pq.top(); pq.pop();
		ll b = pq.top(); pq.pop();
		pq.push(a + b);
		pq.push(a + b);
	}

	while(!pq.empty() ) {
		result += pq.top(); pq.pop();
	}

	cout << result << '\n';

	return 0;
}