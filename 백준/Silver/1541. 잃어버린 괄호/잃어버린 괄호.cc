//처음엔 숫자 형태로 저장해서 자릿수 마다 10^N을 곱해야하나 했는데 문자열은 더하면 이어지니까 숫자일때 문자열로 연결해서 저장한 후 -''를 이용해서 숫자로 만들기??

#include<iostream>
#include<string>
using namespace std;

string s;
int result = 0;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	cin >> s;

	string num;
	bool isMinus = false;

	for (int i = 0; i <= s.size(); ++i) {
		if (s[i] == '-' || s[i] == '+' || s.size() == i) {
			if (isMinus) {
				result -= stoi(num);
				num = "";
			}
			else {
				result += stoi(num);
				num = "";
			}
		}
		else {
			num += s[i];
		}

		if (s[i] == '-')
			isMinus = true;


	}

	cout << result<<'\n';

	return 0;
}