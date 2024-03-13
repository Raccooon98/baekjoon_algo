#include<iostream>
#include<algorithm>

using namespace std;
int N, blue = 0, white = 0;
int paper[128][128];


void cut_paper(int x, int y, int size) {
    int isblue = paper[x][y];

    for (auto i = x; i < x + size; ++i) {
        for (auto j = y; j < y + size; ++j) {
            if (paper[i][j] != isblue) {
                cut_paper(x, y, size / 2);
                cut_paper(x, y + size / 2, size / 2);
                cut_paper(x + size / 2, y, size / 2);
                cut_paper(x + size / 2, y + size / 2, size / 2);
                return;
            }
        }
    }

    //전부 파랑이었으면
    if (isblue == 1)
        blue++;
    else
        white++;
}

int main(void) {
    cin.tie(NULL)->sync_with_stdio(false);

    // 입력
    cin >> N;
    for (auto i = 0; i < N; ++i) {
        for (auto j = 0; j < N; ++j) {
            cin >> paper[i][j];
        }
    }

    // 문제 해결
    cut_paper(0, 0, N);
    cout << white << '\n';
    cout << blue << '\n';
    return 0;
}