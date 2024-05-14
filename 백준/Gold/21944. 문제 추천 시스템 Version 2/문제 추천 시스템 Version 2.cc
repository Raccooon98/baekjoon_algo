#include <iostream>
#include <unordered_set>
#include <set>
#include<algorithm>
using namespace std;

set<pair<int, int> > algorithm[101]; // 알고리즘 : set({난이도, 문제번호})
set<int> level[101];// 난이도 : set(문제번호)
pair<int, int> problem[100001]; // 문제번호 : {난이도, 알고리즘}
int N,M;

int main() {
    cin.tie(0)->sync_with_stdio(false);

    cin >> N;
    while (N--) {
        int p, l, g;
        cin >> p >> l >> g;
        algorithm[g].insert(make_pair(l, p));
        level[l].insert(p);
        problem[p] = make_pair(l, g);
    }
    cin >> M;
    int a, b, c;
    while (M--) {
        string cmd; cin >> cmd;
        if (cmd == "recommend") {
            cin >> a >> b;
            if (b == 1) {
                auto n = prev(algorithm[a].end())->second;
                cout << n << '\n';
            }
            else {
                auto n = algorithm[a].begin()->second;
                cout << n << '\n';
            }
        }
        else if (cmd == "recommend2") {
            cin >> a;
            if (a == 1) {
                for (int i = 100; i >= 1; i--) {
                    if (level[i].empty()) continue;
                    cout << *prev(level[i].end()) << '\n';
                    break;
                }
            }
            else {
                for (int i = 1; i <= 100; i++) {
                    if (level[i].empty()) continue;
                    cout << *level[i].begin() << '\n';
                    break;
                }
            }
        }
        else if (cmd == "recommend3") {
            cin >> a >> b;
            int res = -1;
            if (a == 1) {
                for (int i = b; i <= 100; i++) {
                    if (level[i].empty()) continue;
                    res = *level[i].begin();
                    break;
                }
            }
            else {
                for (int i = b - 1; i >= 1; i--) {
                    if (level[i].empty()) continue;
                    res = *prev(level[i].end());
                    break;
                }
            }
            cout << res << '\n';
        }
        else if (cmd == "add") {
            cin >> a >> b >> c;
            algorithm[c].insert(make_pair(b, a));
            level[b].insert(a);
            problem[a] = make_pair(b, c);
        }
        else if (cmd == "solved") {
            cin >> a;
            auto [l,g] = problem[a];
            //problem[a] = make_pair(0,0);
            algorithm[g].erase(make_pair(l, a));
            level[l].erase(a);
        }
    }

    return 0;
}