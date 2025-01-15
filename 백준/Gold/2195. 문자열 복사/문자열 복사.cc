//목표 문자열의 앞부분부터 기존 문자열 이랑 비교하면서 가장 길이가 긴 구간을 기억해놨다가 기존 문자열에 대한 탐색이 다 끝나면 복사된 문자열에 하나씩 붙여넣기?
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

string origin, target;

int main(void)
{
    cin.tie(NULL)->sync_with_stdio(false);

    cin >> origin >> target;

    int cnt = 0;

    for (int i = 0; i < target.length();) {
        int max_len = 0;
        for (int j = 0; j < origin.length(); ++j) {
            int tmp = 0;
            while (origin[j + tmp] == target[i + tmp]) {
                tmp++;
            }

            max_len = max(max_len, tmp);
        }
        i += max_len;

        cnt++;
    }

    cout << cnt << '\n';
    return 0;
}