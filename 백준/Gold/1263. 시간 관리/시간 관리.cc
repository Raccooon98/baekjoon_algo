//그리디? 뭔가 회의실 배정같은 느낌
#include <iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N;

struct Work {
    int time, deadline;
};

bool compare(Work a, Work b) {
    return a.deadline > b.deadline; // 데드라인 기준 내림차순 정렬
}

int main()
{
	cin.tie(NULL)->sync_with_stdio(false);

    cin >> N;

    vector<Work> v(N);
    for (int i = 0; i < N; ++i) {
        cin >> v[i].time >> v[i].deadline;
    }

    //내림차순 정렬
    sort(v.begin(), v.end(),compare);

    int cur_time = v[0].deadline;//초기에 생각하는 최대 작업시작시간

    for (auto& work : v) {
        cur_time = min(cur_time, work.deadline) - work.time;
        if (cur_time < 0) {
            cout << "-1\n";
            return 0;
        }
    }

    cout << cur_time << '\n';
    return 0;
}