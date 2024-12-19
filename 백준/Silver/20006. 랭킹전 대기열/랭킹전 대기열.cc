#include <iostream>
#include<vector>
#include<algorithm>
#include<cmath>
using namespace std;

int p, m;
vector<pair<string, int>> arr[305];//출력때 닉네임 사전순 정렬을 위해서 string을 앞에 배치하고 sort 돌리기

int main()
{
    cin.tie(NULL)->sync_with_stdio(false);
    cin >> p >> m;
    
    for (int i = 0; i < p; ++i) {
        int a;
        string b;
        cin >> a >> b;

        bool check = 0;

        for (int j = 0; j <= i; ++j) {
            if (arr[j].size() < m && arr[j].size() > 0) {
                if (abs(a- arr[j][0].second) <= 10) {//제일 처음 들어간 플레이어 레벨 기준
                    check = 1;
                    arr[j].push_back({ b,a });
                    break;
                }
            }
        }

        if (!check) {
            arr[i].push_back({ b,a });
        }
    }

    for (int i = 0; i <= p; ++i) {
        int asize = (int)arr[i].size();
        if (asize == 0) {
            continue;
        }
        else if (asize >= m) {
            cout << "Started!" << '\n';
        }
        else if (asize > 0 && asize < m) {
            cout << "Waiting!" << '\n';
        }

        sort(arr[i].begin(), arr[i].end());

        for (auto& temp:arr[i]) {
            cout << temp.second << ' ' << temp.first << '\n';
        }
    }

    return 0;
}