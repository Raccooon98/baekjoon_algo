#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N;
vector<int> v;

void find(int st, int en);


int main()
{
	cin.tie(NULL)->sync_with_stdio(false);

	while (cin >> N) {
		v.push_back(N);
	}
	find(0, v.size());
	return 0;
}

void find(int st, int en) {
	if (st >= en) return;
	if (st == en - 1) {
		cout << v[st] << '\n';
		return;
	}

	int index = st + 1;
	while (index < en) {
		if (v[st] < v[index]) break;
		index++;
	}

	find(st + 1, index);
	find(index, en);

	cout << v[st] << '\n';
	return;
}