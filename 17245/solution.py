n = int(input())
whole = 0
computer_map = {}
for _ in range(n):
    for i in map(int, input().split()):
        whole += i
        if i not in computer_map:
            computer_map[i] = 0
        computer_map[i] += 1

half = whole // 2 + (1 if whole % 2 != 0 else 0)


def evaluate(height):
    return sum(
        [
            min(height * count, computers * count)
            for computers, count in computer_map.items()
        ]
    )


lo = 0
hi = whole
while lo < hi:
    med = (lo + hi) // 2
    computers = evaluate(med)
    if half < computers:
        hi = med
    elif half > computers:
        lo = med + 1
    else:
        lo = med
        break

print(lo)
