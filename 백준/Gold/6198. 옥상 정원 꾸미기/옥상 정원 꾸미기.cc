//무지성 2중 for문은 터질듯
#include <iostream>
#include<algorithm>
#include<stack>
using namespace std;

int N;
long long answer;
stack<int> building;

int main()
{
    cin.tie(NULL)->sync_with_stdio(false);
    cin >> N;
    
    for (int i = 0; i < N; ++i) {
        int a;
        cin >> a;
        
        //스택이 비어있는경우 넣어주기
        if (building.empty()) {
            building.push(a);
            continue;
        }

        while (!building.empty()&&building.top()<=a) {
            building.pop();
        }

        answer += building.size();
        building.push(a);

    }

    cout << answer;

    return 0;
}