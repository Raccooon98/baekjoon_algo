//길이가 K인 슬라이딩 윈도우를 밀면서 수리할 갯수 체크하기
#include<algorithm>
#include <iostream>
using namespace std;

int arr[100005];
int N, K, B;

int main()
{
    cin.tie(NULL)->sync_with_stdio(false);

    cin >> N >> K >> B;

    for (int i = 0; i < B; ++i) {
        int a;
        cin >> a;
        arr[a] = 1;
    }

    // 초기 슬라이딩 윈도우 내 고장난 신호등 개수 계산
    int cur = 0;
    for (int i = 1; i <= K; ++i) {
        cur += arr[i];
    }

    int Min = cur;

    // 슬라이딩 윈도우 이동
    for (int i = K + 1; i <= N; ++i) {
        cur += arr[i];       // 새로 추가된 신호등 상태 추가
        cur -= arr[i - K];  // 윈도우에서 벗어난 신호등 상태 제거
        Min = min(Min, cur);
    }

    cout << Min << "\n";

    return 0;
}