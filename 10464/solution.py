t = int(input())

for _ in range(t):
    s, f = map(int, input().split())
    l = f - s + 1
    if s % 2 == 0:
        print(((l // 2) % 2) ^ (f if l % 2 else 0))
    else:
        print(s ^ (((l - 1) // 2) % 2) ^ (0 if l % 2 else f))
