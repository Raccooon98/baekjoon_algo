#include <iostream>
#include <algorithm>
using namespace std;

int N, X, L, R, ans = 0;

int arr[16];
bool check[16];

bool cmp(int a, int b) {
    return a > b;
}

void select(int idx, int cnt, int sum) {
    if (cnt >= 2) {
        int maxnum = 0, minnum = 0;
        for (int i = 0; i < N; ++i) {
            if (check[i]) {
                maxnum = arr[i];
                break;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if (check[i]) {
                minnum = arr[i];
                break;
            }
        }

        if (sum >= L && sum <= R && (maxnum - minnum) >= X) {
            ans++;
        }
    }


    for (int i = idx; i < N; ++i) {
        check[i] = true;
        select(i + 1, cnt + 1, sum + arr[i]);
        check[i] = false;
    }
}

int main()
{
    cin.tie(NULL)->sync_with_stdio(false);

    cin >> N >> L >> R >> X;

    for (int i = 0; i < N; ++i) {
        cin >> arr[i];
    }

    sort(arr, arr + N, cmp);

    select(0, 0, 0);

    cout << ans << '\n';

    return 0;
}
