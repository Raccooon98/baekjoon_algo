#include <iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N, M;
int books[55];
vector<int> pos, neg;

int main(void)
{
    cin.tie(NULL)->sync_with_stdio(false);

    cin >> N >> M;

    for (int i = 0; i < N; ++i) {
        int a;
        cin >> a;
        if (a > 0) {
            pos.push_back(a);
        }
        else
            neg.push_back(-a);
    }
    int res = 0;
    int posnum = pos.size();
    int negnum = neg.size();
    sort(pos.begin(), pos.end());
    sort(neg.begin(), neg.end());

    for (int i = posnum - 1; i >= 0; i -= M) {
        res += pos[i] * 2;
    }

    for (int j = negnum - 1; j >= 0; j -= M) {
        res += neg[j] * 2;
    }

    if (posnum>0&&negnum>0) {
        if (pos[posnum - 1] > neg[negnum - 1])
            res -= pos[posnum - 1];
        else
            res -= neg[negnum - 1];
    }
    else if (posnum > 0) {
        res -= pos[posnum - 1];
    }
    else
        res -= neg[negnum - 1];

    cout << res << '\n';

    return 0;
    
}