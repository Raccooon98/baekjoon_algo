#include<iostream>
#include<algorithm>
#include<unordered_map>
#include<vector>
using namespace std;

int N;
unordered_map<string, string> person;
vector<string> s;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;

	for (int i = 0; i < N; ++i) {
		string a, b;
		cin >> a >> b;
		person[a] = b;
	}

	for (auto [a, b] : person) {
		if (b == "enter")
			s.push_back(a);
	}
	sort(s.begin(), s.end(), greater<string>());

	for (auto v : s) cout << v << '\n';
	return 0;

}