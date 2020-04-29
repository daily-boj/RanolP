a, b, c = map(int, input().split())
i, j, k = map(int, input().split())

uses = min(a / i, b / j, c / k)

print(a - i * uses, b - j * uses, c - k * uses)
