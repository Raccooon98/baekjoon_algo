//일단 선행관계라는 말이 나오면 위상정렬부터 의심하자 간선의 방향성이 없고 비용이 없다면 거의 확정
#include <iostream>
#include <vector>
#include<queue>
using namespace std;

int N;
vector<int> node[10005];
int indegree[10005];
int cost[10005];
int result[10005];

int main(void)
{
    cin.tie(NULL)->sync_with_stdio(false);
    cin >> N;

    queue<int> q;

    for (int i = 1; i <= N; ++i) {
        cin >> cost[i];
        int n;
        cin >> n;
        for (int j = 0; j < n; ++j) {
            int num;
            cin >> num;
            node[num].push_back(i);
            indegree[i]++;
        }
    }

    for (int i = 1; i <= N; ++i) {
        if (indegree[i] == 0)
            q.push(i);

        result[i] = cost[i];
    }

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        for (auto num : node[cur]) {
            int next = num;
            indegree[next]--;

            result[next] = max(result[next], result[cur] + cost[next]);

            if (indegree[next] == 0) {
                q.push(next);
            }
        }
    }

    int ans = -1;
    for (int i = 1; i <= N; ++i) {
        ans = max(ans, result[i]);
    }

    cout << ans<<'\n';
    return 0;
}