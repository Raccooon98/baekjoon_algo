//소수? 에라토스테네스의 체 생각해보기
//에라토스테네스의 체를 만들고,,,,,,, 각 자리수 별로 순회를 하면서 소수이면 변환? 음,,,,
#include <iostream>
#include<algorithm>
#include<cstring>
#include<string>
#include<cmath>
#include<vector>
#include<queue>
using namespace std;

int primenumber[10001];
bool vis[10001];
int prime = 10000;

void make_primeNum() {
    for (int i = 2; i <= prime; ++i) {
        primenumber[i] = i;
    }

    for (int i = 2; i <= sqrt(prime); ++i) {
        if (primenumber[i] == 0 ) {
            continue;
        }

        for (int j = i * i; j < prime; j+=i) {
                primenumber[j] = 0;
        }
    }
}

void sol(int start, int end) {
    queue<pair<int, int>> q;

    q.push({ start,0 });
    vis[start] = true;

    while (!q.empty()) {
        int cur_num = q.front().first;
        int cur_cnt = q.front().second;
        q.pop();

        if (cur_num == end) {
            cout << cur_cnt << '\n';
            break;
        }

        for (int i = 0; i < 4; ++i) {
            int next = 0;
            for (int j = 0; j < 10; ++j) {
                string s = to_string(cur_num);
                s[i] = j + '0';
                next = stoi(s);
                
                if (primenumber[next] == 0)continue;
                if (vis[next] == true)continue;
                if (next >= 10000 || next < 1000)continue;

                vis[next] = true;
                q.push({ next,cur_cnt + 1 });
            }
        }
    }
}

int main(void)
{
    cin.tie(NULL)->sync_with_stdio(false);
    
    make_primeNum();

    int T;
    cin >> T;

    for (int TC = 1; TC <= T; ++TC) {
        memset(vis, false, sizeof(vis));
        int from, to;
        cin >> from >> to;
        
        int result = 0;
        if (from == to) {
            cout << result << '\n';
            continue;
        }

        sol(from, to);
    }
}