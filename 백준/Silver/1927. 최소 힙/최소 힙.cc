#include <queue>
#include <iostream>
#include <vector>

using namespace std;
int N;
priority_queue<int, vector<int>, greater<int>> pq;

int main() {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;

	for (int i = 0; i < N; ++i) {
		int num;
		cin >> num;

		if (num == 0) {
			if (pq.empty())
				cout << 0 << "\n";
			else {
				cout << pq.top() << "\n";
				pq.pop();
			}
		}
		else {
			pq.push(num);
		}
	}

	return 0;
}