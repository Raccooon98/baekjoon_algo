#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

int A[1005], B[1005], psum1[2005], psum2[2005];
int P, N, M, res;
unordered_map<int, int> map1, map2;

int main(void)
{
    cin.tie(NULL)->sync_with_stdio(false);
    cin >> P >> N >> M;

    // 피자 A 이어붙이기
    for (int i = 1; i <= N; ++i) {
        cin >> A[i];
        psum1[i] = psum1[i - 1] + A[i];
    }
    for (int i = N + 1; i <= N * 2; ++i) {
        psum1[i] = psum1[i - 1] + A[i - N];
    }

    // 피자 B 이어붙이기
    for (int i = 1; i <= M; ++i) {
        cin >> B[i];
        psum2[i] = psum2[i - 1] + B[i];
    }
    for (int i = M + 1; i <= M * 2; ++i) {
        psum2[i] = psum2[i - 1] + B[i - M];
    }

    for (int i = 1; i <= N; ++i) {
        for (int j = 0; j < N; ++j) { 
            int end = j + i;
            int sum = psum1[end] - psum1[j];
            map1[sum]++;
            if (i == N) break; // 전체 피자 크기인 경우 한 번만 처리
        }
    }

    for (int i = 1; i <= M; ++i) {
        for (int j = 0; j < M; ++j) { 
            int end = j + i;
            int sum = psum2[end] - psum2[j];
            map2[sum]++;
            if (i == M) break;
        }
    }

    res = map1[P] + map2[P]; // A 또는 B에서 P가 되는 경우
    for (int i = 1; i < P; ++i) {
        res += map1[i] * map2[P - i]; // A와 B를 섞어서 P가 되는 경우
    }

    cout << res << '\n';
    return 0;
}
