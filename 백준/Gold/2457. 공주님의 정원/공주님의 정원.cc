#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
struct Flower {
    int start, end;

    // 월과 일을 입력 받아 일수로 변경
    static int mtod(int month, int day) {
        int days_in_month[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int total_days = 0;
        for (int i = 1; i < month; ++i) {
            total_days += days_in_month[i];
        }
        return total_days + day;
    }

    // 비교연산자
    bool operator < (const Flower& other) const {
        if (start == other.start) {
            return end > other.end;
        }
        return start < other.start;
    }
};

int N;

int main() {
    cin >> N;

    vector<Flower> flowers;
    for (int i = 0; i < N; ++i) {
        int sm, sd, em, ed;
        cin >> sm >> sd >> em >> ed;
        flowers.push_back({ Flower::mtod(sm, sd), Flower::mtod(em, ed) });
    }

    // 꽃이 피는 순으로 정렬
    sort(flowers.begin(), flowers.end());

    int count = 0;
    int cur_end = Flower::mtod(3, 1);
    int max_end = Flower::mtod(11, 30);
    int idx = 0;
    int last_end = 0;

    while (cur_end <= max_end) {
        bool updated = false;
        for (int i = idx; i < N; ++i) {
            if (flowers[i].start > cur_end) {
                break;
            }
            if (flowers[i].end > last_end) {
                last_end = flowers[i].end;
                idx = i;
                updated = true;
            }
        }

        if (!updated) {
            count = 0;
            break;
        }

        cur_end = last_end;
        count++;
        idx++;
    }

    if (cur_end <= max_end) {
        cout << 0 << endl;
    }
    else {
        cout << count << endl;
    }

    return 0;
}
