#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>

using namespace std;

bool canfold(string str, int st, int en) {

	if (st >= en) {
		return true;
	}

	int left = st, right = en;
	while (left < right) {
		if (str[left] != str[right]) {
			left++; right--;
		}
		else {
			return false;
		}
	}
	return canfold(str, st, right - 1);
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	int TC{};
	cin >> TC;

	for (int T = 1; T <= TC; ++T){
		//무조건 홀수 길이의 문자열
		string s;
		cin >> s;

		if (s.length() == 1) {//1이면 무조건 어느 방향으로도 접을 수 있음
			cout << "YES"<<'\n';
			continue;
		}

		if (canfold(s, 0, s.length() - 1)) {
			cout << "YES" << '\n';
		}else{
			cout << "NO" << '\n';
		}
	}
}

