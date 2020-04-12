_, k = map(int, input().split())
temperatures = list(map(int, input().split()))

max = sum(temperatures[:k])
prev = max

for (i, n) in enumerate(temperatures[k:]):
    curr = prev - temperatures[i] + n
    if curr > max:
        max = curr
    prev = curr

print(max)
