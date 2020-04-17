n, m, k = map(int, input().split())

result = 0
while n + m - 3 >= k and n >= 2 and m >= 1:
    n -= 2
    m -= 1
    result += 1

print(result)
