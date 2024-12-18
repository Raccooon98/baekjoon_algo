#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int dp[105][105][105];

int main(void)
{
    cin.tie(NULL)->sync_with_stdio(false);

    string s1, s2, s3;
    cin >> s1 >> s2 >> s3;
    //인덱스 1부터 시작하게 0번을 공백으로 채워주기
    s1 = ' ' + s1;
    s2 = ' ' + s2;
    s3 = ' ' + s3;

    for (int i = 1; i < s1.size(); ++i) {
        for (int j = 1; j < s2.size(); ++j) {
            for (int k = 1; k < s3.size(); ++k) {
                if (s1[i] == s2[j] && s2[j] == s3[k]) {//문자 3개가 다 같으면
                    dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                }
                else {
                    dp[i][j][k] = max(max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                }
            }
        }
    }

    cout << dp[s1.size() - 1][s2.size() - 1][s3.size() - 1]<<'\n';

    return 0;
}