#include<bits/stdc++.h>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;
    
    for(long long i=left; i<=right;i++){
        int col = i%n+1;
        int row = i/n+1;
        
        int num = max(col,row);
        
        answer.push_back(num);
    }
    
    return answer;
}