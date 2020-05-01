from bisect import bisect_left, insort

n = int(input())
y_map = [[0] for _ in range(10004)]
to_check = []
for _ in range(n):
    y, x1, x2 = map(int, input().split())
    for x in range(x1, x2):
        insort(y_map[x], y)

    to_check.append((x1, y))
    to_check.append((x2 - 1, y))

answer = 0

for x, y in to_check:
    array = y_map[x]
    index = bisect_left(array, y) - 1
    answer += y - array[index]

print(answer)
