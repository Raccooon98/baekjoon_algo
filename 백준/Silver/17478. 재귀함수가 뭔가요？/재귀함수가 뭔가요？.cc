//단순 재귀함수 구현 조건이랑 순서 잘 지켜보기
#include<iostream>
#include<algorithm>

using namespace std;
int N;
//언더바도 따로 함수로 빼야함
void underbar(int a) {
	for (auto i = 0; i < N - a; ++i) cout << "____";
}


void output(int n) {
	underbar(n);
	cout << "\"재귀함수가 뭔가요?\"\n";
	//종료조건
	if (n == 0) {
		underbar(n);
		cout << "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
		underbar(n);
		cout << "라고 답변하였지.\n";
		return;
	}
	//반복할 부분
	underbar(n);	
	cout << "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	underbar(n);
	cout << "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	underbar(n);
	cout << "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	output(n-1);
	underbar(n);
	cout << "라고 답변하였지.\n";

}

int main() {
	cin >> N;
	cout << "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다." << '\n';
	output(N);
}