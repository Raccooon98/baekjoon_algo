#include <iostream>
#include<algorithm>
#include<cstring>
#include<vector>
using namespace std;

int N;
int arr[105];
bool vis[105];
vector<int> ans;

void DFS(int cur, int st) {
    if (vis[cur]) {
        if (st == cur)ans.emplace_back(cur);
        return;
    }

    vis[cur] = true;
    DFS(arr[cur], st);
}

int main(void)
{
    cin.tie(NULL)->sync_with_stdio(false);

    cin >> N;
    for (int i = 1; i <= N; ++i) {
        cin >> arr[i];
    }

    for (int i = 1; i <= N; ++i) {
        memset(vis, 0, sizeof(vis));
        DFS(i, i);
    }
    cout << ans.size() << '\n';
    for (auto& n : ans) {
        cout << n << '\n';
    }

    return 0;
}