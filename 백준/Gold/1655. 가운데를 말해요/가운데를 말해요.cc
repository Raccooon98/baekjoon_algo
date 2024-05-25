//갯수 최대치가 10만이니까 이중for문 하면 시간초과 확정
//이분탐색이나 우선순위큐로 해결하기
#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

int N;
priority_queue<int> maxheap;
priority_queue<int, vector<int>, greater<int>> minheap;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	for (int i = 0; i < N; ++i) {
		int a;
		cin >> a;
		if (maxheap.empty()) {
			maxheap.push(a);
		}
		else if (maxheap.size() == minheap.size()) {
			maxheap.push(a);
		}
		else {
			minheap.push(a);
		}

		if (!maxheap.empty() && !minheap.empty() && (maxheap.top() > minheap.top())) {
			int a = maxheap.top();
			int b = minheap.top();

			maxheap.pop();
			minheap.pop();

			maxheap.push(b);
			minheap.push(a);
		}
		cout << maxheap.top() << '\n';
	}
	return 0;
}