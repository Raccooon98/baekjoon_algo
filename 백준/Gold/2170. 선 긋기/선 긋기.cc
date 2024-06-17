//처음들어오는 입력이 시작점, 두번째 도착점 / 정렬해놓고 그리디 처럼 풀면 될듯?
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
using ll = long long;

vector<pair<ll, ll>> v;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	int N,tmp;
	cin >> N;
	tmp = N;
	while (tmp--) {
		ll a, b;
		cin >> a >> b;
		v.push_back({ a,b });
	}

	sort(v.begin(), v.end());

	ll sum = 0;
	auto& [st, en] = v[0];
	if (N == 1) {
		cout << en - st << '\n';
		return 0;
	}

	//for(auto&[a,b]:)
	for (int i = 1; i < N; ++i) {
		auto& [a, b] = v[i];
		if (en < a) { // 안겹침
			sum += en - st;
			st = a;
			en = b;
		}
		else { // 
			if (en < b) // 선 연장
				en = b;
		}
	}

	sum += en - st;
	cout << sum << '\n';

	return 0;
}