#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N, M, st, en, mid, result;

int main(void) {
    cin.tie(NULL)->sync_with_stdio(false);

    cin >> M >> N;
    vector<long long> snacks(N);
    for (int n = 0; n < N; ++n) {
        cin >> snacks[n];
    }
    sort(snacks.begin(), snacks.end());

    en = snacks[N - 1]; // 최대 스낵크기로 설정
    while (st <= en) {
        
        mid = (st + en+1) / 2;

        if (mid == 0) {
            cout << 0 << '\n';
            return 0;
        }
        long long count = 0;
        // mid 길이로 잘랐을 때 M개 이상의 스낵을 만들 수 있는지 확인
        for (int i = 0; i < N; ++i) {
            count += snacks[i] / mid;
        }
        if (count >= M) {
            result = mid; // 가능하면 결과 저장하고 더 큰 길이 탐색
            st = mid + 1;
        }
        else {
            en = mid - 1; // 불가능하면 더 작은 길이 탐색
        }
    }

    cout << result << '\n';

    return 0;
}
