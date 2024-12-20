#include <iostream>
#include <vector>
#include <sstream>
using namespace std;

int N, M, H;
int dp[55][1005]; 
vector<int> block[55];

int main() {
	cin.tie(NULL)->sync_with_stdio(false);
	cin >> N >> M >> H;
	cin.ignore();

	for (int i = 1; i <= N; ++i) {
		string line;
		getline(cin, line); 
		stringstream ss(line);
		int num;
		while (ss >> num) {
			block[i].push_back(num);
		}
	}

	
	dp[0][0] = 1;

	
	for (int i = 1; i <= N; ++i) {
		for (int j = 0; j <= H; ++j) {
			dp[i][j] = dp[i - 1][j];
			for (int k = 0; k < block[i].size(); ++k) {
				if (j >= block[i][k]) {
					dp[i][j] = (dp[i][j] + dp[i - 1][j - block[i][k]]) % 10007;
				}
			}
		}
	}

	cout << dp[N][H] << '\n'; 
	return 0;
}
