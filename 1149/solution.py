count = int(input())

rgb_map = eval("list(map(int, input().split()))," * count)

dp = [[0, 0, 0] for _ in range(count)]

for i in range(count - 1, -1, -1):
    is_last = i + 1 == count
    dp[i][0] = rgb_map[i][0] + (0 if is_last else min(dp[i + 1][1], dp[i + 1][2]))
    dp[i][1] = rgb_map[i][1] + (0 if is_last else min(dp[i + 1][0], dp[i + 1][2]))
    dp[i][2] = rgb_map[i][2] + (0 if is_last else min(dp[i + 1][0], dp[i + 1][1]))

print(min(dp[0]))
