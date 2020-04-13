n, k = map(int, input().split())

a = eval("int(input())," * n)

coins = 0

for i in a[-1::-1]:
    if k >= i:
        count = k // i
        k -= i * count
        coins += count

print(coins)
