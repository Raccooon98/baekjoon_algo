//정렬을 계속 해주기에는 너무 비효율적임 우선순위 큐 ㄱㄱ
// 각 칸에 100만까지 들어갈 수 있는데 칸이 10000개면 합했을때 100억이 나오기떄문에 int 말고 long long 해야될듯

#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;
using ll = long long;

int T, N;
ll result;


int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	cin >> T;
	for (int t = 0; t < T; ++t) {
		result = 0;
		cin >> N;
		priority_queue<ll, vector<ll>, greater<ll>> pq;

		for (int i = 0; i < N; ++i) {
			int a;
			cin >> a;
			pq.push(a);
		}

		while (!pq.empty()) {
			if (pq.size() == 1)break;
			ll num1 = pq.top();
			pq.pop();
			ll num2 = pq.top();
			pq.pop();

			result += num1 + num2;
			pq.push(num1 + num2);
		}
		
		cout << result << '\n';
	}
	return 0;
}