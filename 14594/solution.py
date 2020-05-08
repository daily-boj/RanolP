n = int(input())

available = (0b1 << (n - 1)) - 1

for _ in range(int(input())):
    x, y = map(int, input().split())
    l = y - x
    bit = (0b1 << l) - 1
    bit = bit << (x - 1)
    available &= ~bit

print(sum(1 for c in bin(available)[2:] if c == "1") + 1)
