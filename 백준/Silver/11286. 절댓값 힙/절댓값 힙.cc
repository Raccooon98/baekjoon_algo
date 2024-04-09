#include <queue>
#include <iostream>
#include <vector>
#include<cmath>

using namespace std;
int N;



struct absol {
	int a;
	bool operator<(const absol& other)const {
		if (abs(a) == abs(other.a))
			return a > other.a;
		return abs(a) > abs(other.a);
	}
};

priority_queue<absol> pq;

int main() {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;

	for (int i = 0; i < N; ++i) {
		int num;
		cin >> num;

		if (num == 0) {
			if (pq.empty())
				cout<< 0 << "\n";
			else {
				cout  << pq.top().a << "\n";
				pq.pop();

			}
		}
		else {
			pq.push({ num });
		}
	}

	return 0;
}