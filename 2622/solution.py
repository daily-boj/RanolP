count = int(input())

able = 0

for i in range(1, count // 3 + 1):
    for j in range(i, (count - i) // 2 + 1):
        if i + j > count - i - j:
            able += 1

print(able)
