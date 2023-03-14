n,m=map(int,input().split())
A=[list(map(int,input().split())) for _ in range(n)]
B=[list(map(int,input().split())) for _ in range(n)]

for x in range(n):
    for y in range(m):
        print(A[x][y]+B[x][y], end=' ')
    print()
    