n = int(input())

answer = 0
i = 1
for j in range(n + 1):
    answer += i
    if j % 3 != 0:
        i += 1

print(answer)
