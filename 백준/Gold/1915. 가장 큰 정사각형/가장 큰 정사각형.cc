#include <iostream>
#include <algorithm>
#include <string>
#include <cstring>
using namespace std;

int N, M;
int Map[1005][1005];
int maxlen = 0;

int main()
{
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;
	for (int i = 0; i < N; ++i) {
		string s;
		cin >> s;
		for (int j = 0; j < M; ++j) {
			Map[i][j] = s[j] - '0';
		}
	}

	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < M; ++j) {
			if (Map[i][j] == 1 && i > 0 && j > 0) {
				Map[i][j] = min({ Map[i][j - 1], Map[i - 1][j], Map[i - 1][j - 1] }) + 1;
			}
			maxlen = max(maxlen, Map[i][j]);
		}
	}

	cout << maxlen * maxlen << '\n';
	return 0;
}
