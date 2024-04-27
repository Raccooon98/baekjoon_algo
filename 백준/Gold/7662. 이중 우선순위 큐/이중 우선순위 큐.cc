//동일한 정수가 삽입될 수 있음
#include<iostream>
#include<algorithm>
#include<set>
#include<vector>
#include<string>
using namespace std;

int t;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> t;
	for (int i = 0; i < t; ++i) {
		int k;
		cin >> k;
		multiset<int> arr;

		for (int j = 0; j < k; ++j) {
			char cal;
			cin >> cal;
			if (cal == 'D') {
				int num;
				cin >> num;
				if (arr.empty())continue;
				if (num == 1)arr.erase(prev(arr.end()));
				else arr.erase(arr.begin());
			}
			else if (cal == 'I') {
				int num;
				cin >> num;
				arr.insert(num);
			}
		}
		if (arr.empty())cout << "EMPTY\n";
		else
			cout << *prev(arr.end()) << ' ' << *arr.begin() << '\n';
	}

	return 0;
}