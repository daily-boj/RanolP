x, y, p1, p2 = map(int, input().split())

xs = set()
cx = p1
ys = set()
cy = p2

for _ in range(100_000):
    xs.add(cx)
    ys.add(cy)
    cx += x
    cy += y

i = xs & ys

print(min(i or [-1]))
