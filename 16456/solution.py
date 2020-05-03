n = int(input())

dp = [1, 1, 1]
for i in range(3, n + 1):
    dp.append(dp[i - 3] % 1000000009 + dp[i - 1] % 1000000009)

print(dp[n] % 1000000009)
