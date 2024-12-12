//냅색 DP문제?
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, T;
long long dp[10005];

int main(void)
{
    cin.tie(NULL)->sync_with_stdio(false);

    cin >> N >> T;

    for (int i = 0; i < N; ++i) {
        int k, s;
        cin >> k >> s;
        for (int j = T; j >= k; --j) {
            dp[j] = max(dp[j], dp[j - k] + s);
        }
    }

    cout << dp[T] << '\n';

    return 0;
}