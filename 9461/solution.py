dp = [1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12]


def p(n):
    if n >= len(dp):
        dp.append(p(n - 1) + p(n - 5))
    return dp[n]


T = int(input())

for _ in range(T):
    n = int(input())
    print(p(n - 1))
