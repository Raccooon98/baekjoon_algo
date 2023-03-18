num = []
for i in range(30):
    num.append(i+1)
for n in range(28):
    num.remove(int(input()))
print(min(num))
print(max(num))