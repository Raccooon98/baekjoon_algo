#include <iostream>
#include <algorithm>

using namespace std;

int N, M;
int first[9];
int arr[9];
bool visited[9];

void dfs(int num, int k) { 
    if (k == M) { 
        for (auto i = 0; i < M; i++)
            cout << arr[i] << " "; 
        cout << "\n";
    }
    else { 
        for (auto i = num; i <= N; i++) { //오름차순
            if (!visited[i]) { //방문 안 했다면
                visited[i] = true; 
                arr[k] = first[i - 1]; 
                dfs(i + 1, k + 1); 
                visited[i] = false; 
            }
        }
    }
}

int main() {
    cin >> N >> M;

    for (int i = 0; i < N; i++)
        cin >> first[i];

    sort(first, first + N); //정렬

    dfs(1, 0);
}