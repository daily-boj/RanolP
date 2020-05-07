n = int(input())
a = map(int, input().split())
accu = [0]
for i in a:
    accu.append(accu[-1] + i)

for _ in range(int(input())):
    i, j = map(int, input().split())
    print(accu[j] - accu[i - 1])
