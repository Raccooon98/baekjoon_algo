#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<int> A(N), dp(N, 1), prev(N, -1);
    vector<int> arr; // 가장 긴 증가하는 부분 수열을 저장할 벡터

    for (int i = 0; i < N; ++i) {
        cin >> A[i];
    }

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < i; ++j) {
            if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1;
                prev[i] = j;
            }
        }
    }

 
    int len = 0, end = 0;
    for (int i = 0; i < N; ++i) {
        if (len < dp[i]) {
            len = dp[i];
            end = i;
        }
    }

  
    for (int i = end; i != -1; i = prev[i]) {
        arr.push_back(A[i]);
    }
    reverse(arr.begin(), arr.end());

    // 결과 출력
    cout << len << '\n';
    for (int i : arr) {
        cout << i << ' ';
    }
    cout << '\n';

    return 0;
}
