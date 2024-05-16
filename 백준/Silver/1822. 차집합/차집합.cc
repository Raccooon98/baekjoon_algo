//집합이고 중복 없으니까 set로ㄱㄱ
#include<iostream>
#include<set>
#include<algorithm>
using namespace std;

set<int> A;
int na, nb;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> na >> nb;
	while (na--) {
		int a;
		cin >> a;
		A.insert(a);
	}

	while (nb--) {
		int a;
		cin >> a;
		auto check = A.find(a);
		if (check == A.end()) {
			continue;
		}
		else
			A.erase(a);
	}

	cout << A.size() << '\n';
	for (auto a : A) {
		cout << a << ' ';
	}

	return 0;
}