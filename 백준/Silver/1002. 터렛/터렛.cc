#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;


int main(void) {
	int T, x1, y1, r1, x2, y2, r2;
	int d,con1,con2;
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
		d = (x1 - x2)* (x1 - x2) + (y1 - y2)* (y1 - y2);
		con1 = (r1 - r2) * (r1 - r2);
		con2 = (r1 + r2) * (r1 + r2);

		if (d == 0) {
			if (con1 == 0)
				cout << "-1" << '\n';
			else
				cout << "0" << '\n';
		}
		else if (d == con1 || d == con2)
			cout << "1" << '\n';
		else if (con1 < d && d < con2)
			cout << "2" <<'\n';
		else
			cout << "0" << '\n';
	}
}