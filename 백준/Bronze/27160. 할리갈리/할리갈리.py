num = int(input())
cards = {
    'STRAWBERRY':0,
    'BANANA':0,
    'LIME':0,
    'PLUM':0
}
for _ in range(num):
    fruit,counts=input().split()
    cards[fruit]+=int(counts)
check = 5 in cards.values()
if check: print('YES')
else:
    print('NO')