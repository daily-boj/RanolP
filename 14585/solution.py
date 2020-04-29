n, m = map(int, input().split())
candy_map = [[False for _ in range(301)] for _ in range(301)]

for _ in range(n):
    x, y = map(int, input().split())
    candy_map[x][y] = True

best_map = [[[] for _ in range(301)] for _ in range(301)]

for x in reversed(range(0, 301)):
    for y in reversed(range(0, 301)):
        if candy_map[x][y]:
            best_map[x][y] += [m]
        right = best_map[x + 1][y] if x < 300 else []
        top = best_map[x][y + 1] if y < 300 else []
        maximized = max([top, right], key=sum)
        best_map[x][y] += [v - 1 for v in maximized if v > 0]

print(sum(best_map[0][0]))
