#include <iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N;
vector<pair<int,int>> v;

pair<long double, long double> CastType(const std::pair<int, int>& p) {
	return { static_cast<long double>(p.first), static_cast<long double>(p.second) };
}

long double cal(int i, int j) {
	auto[a, b] = CastType(v[0]);
	auto[c, d] = CastType(v[i]);
	auto[e, f] = CastType(v[j]);

	return (a * d + c * f + e * b - c * b - e * d - a * f) / 2;
}


int main(void)
{
	cin.tie(NULL)->sync_with_stdio(false);
	cout << fixed;
	cout.precision(1);

	cin >> N;
	for (int i = 0; i < N; ++i) {
		int a, b;
		cin >> a >> b;
		v.push_back({ a,b });
	}

	long double res = 0;
	for (int i = 1; i < N - 1; ++i) {
		res += cal(i, i + 1);
	}

	
	cout << abs(res) << '\n';

	return 0;
}