#include <iostream>
#include <vector>
#include <string>
#include <cmath>
using namespace std;

int N, K, P, X, answer = 0;
vector<vector<int>> arr{
	{1, 1, 1, 0, 1, 1, 1},
	{0, 0, 1, 0, 0, 1, 0},
	{1, 0, 1, 1, 1, 0, 1},
	{1, 0, 1, 1, 0, 1, 1},
	{0, 1, 1, 1, 0, 1, 0},
	{1, 1, 0, 1, 0, 1, 1},
	{1, 1, 0, 1, 1, 1, 1},
	{1, 0, 1, 0, 0, 1, 0},
	{1, 1, 1, 1, 1, 1, 1},
	{1, 1, 1, 1, 0, 1, 1}
};

int get_diff(int a, int b) {
	int diff = 0;
	for (int i = 0; i < 7; i++) {
		diff += abs(arr[a][i] - arr[b][i]);
	}
	return diff;
}

int main() {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> K >> P >> X;
	string x_str = string(K - to_string(X).size(), '0') + to_string(X);

	for (int i = 1; i <= N; i++) {
		string i_str = string(K - to_string(i).size(), '0') + to_string(i);

		int sum_diff = 0;
		for (int j = 0; j < K; j++) {
			sum_diff += get_diff(x_str[j] - '0', i_str[j] - '0');
		}

		if (sum_diff >= 1 && sum_diff <= P) {
			answer++;
		}
	}

	cout << answer << '\n';
}
