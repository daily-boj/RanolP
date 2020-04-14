from bisect import bisect_right

_, count = map(int, input().split())
t = list(map(int, input().split()))
dp = []
for i in t:
    if len(dp) == 0:
        dp.append(i)
    else:
        dp.append(i + dp[-1])
for i in eval("int(input())," * count):
    print(bisect_right(dp, i))
